package com.example.markiiimark.batchprocessing.controller

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.JobParametersInvalidException
import org.springframework.batch.core.launch.JobInstanceAlreadyExistsException
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.batch.operations.JobExecutionAlreadyCompleteException
import javax.batch.operations.JobRestartException

@RestController
@RequestMapping("/jobs")
class JobController {

    @Autowired private lateinit var jobLauncher: JobLauncher
    @Autowired private lateinit var job: Job

    @PostMapping("/importCustomers")
    fun importCsvToDBJob() {
        val jobParameters = JobParametersBuilder()
            .addLong("startAt", System.currentTimeMillis()).toJobParameters()

        try {
            jobLauncher.run(job, jobParameters)
        } catch (e: JobExecutionAlreadyCompleteException) {
            e.printStackTrace()
        } catch (e: JobRestartException) {
            e.printStackTrace()
        } catch (e: JobInstanceAlreadyCompleteException) {
            e.printStackTrace()
        } catch (e: JobParametersInvalidException) {
            e.printStackTrace()
        }
    }

}