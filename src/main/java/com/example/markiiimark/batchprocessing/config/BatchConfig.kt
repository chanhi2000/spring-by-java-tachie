package com.example.markiiimark.batchprocessing.config

import com.example.markiiimark.batchprocessing.entity.Customer
import com.example.markiiimark.batchprocessing.repository.CustomerRepository
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.item.data.RepositoryItemWriter
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.LineMapper
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper
import org.springframework.batch.item.file.mapping.DefaultLineMapper
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource

@Configuration
@EnableBatchProcessing
class BatchConfig(
    private var jobBuilderFactory: JobBuilderFactory,
    private var stepBuilderFactory: StepBuilderFactory,
    private var customerRespository: CustomerRepository,
) {
    @Bean
    fun reader(): FlatFileItemReader<Customer> {
        val itemReader = FlatFileItemReader<Customer>()
        itemReader.setResource(FileSystemResource("src/main/resources/customers.csv"))
        itemReader.setName("csvReader")
        itemReader.setLinesToSkip(1)
        itemReader.setLineMapper(lineMapper())
        return itemReader
    }

    @Bean
    fun lineMapper(): LineMapper<Customer> {
        val lineMapper = DefaultLineMapper<Customer>()

        val lineTokenizer = DelimitedLineTokenizer()
        lineTokenizer.setDelimiter(",")
        lineTokenizer.setStrict(false)
        lineTokenizer.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob")

        val fieldSetMapper = BeanWrapperFieldSetMapper<Customer>()
        fieldSetMapper.setTargetType(Customer::class.java)
        lineMapper.setFieldSetMapper(fieldSetMapper)
        lineMapper.setLineTokenizer(lineTokenizer)

        return lineMapper
    }

    @Bean
    fun processor(): CustomerProcessor = CustomerProcessor()

    @Bean
    fun writer(): RepositoryItemWriter<Customer> {
        val writer = RepositoryItemWriter<Customer>()
        writer.setRepository(customerRespository)
        writer.setMethodName("save")
        return writer
    }

    @Bean
    fun step1() : Step {
        return stepBuilderFactory.get("csv-step").chunk<Customer, Customer>(10)
            .reader(reader())
            .processor(processor())
            .writer(writer())
            .build()
    }

    @Bean
    fun runJob(): Job {
        return jobBuilderFactory.get("importCustomers")
            .flow(step1())
            .end()
//            .next()
            .build()

    }

}