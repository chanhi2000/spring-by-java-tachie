package com.example.markiiimark.batchprocessing.config

import org.springframework.batch.item.ItemProcessor

import com.example.markiiimark.batchprocessing.entity.Customer

class CustomerProcessor : ItemProcessor<Customer, Customer>{
    override fun process(item: Customer): Customer? {
        return if (item.country == "United States") item else null
    }
}