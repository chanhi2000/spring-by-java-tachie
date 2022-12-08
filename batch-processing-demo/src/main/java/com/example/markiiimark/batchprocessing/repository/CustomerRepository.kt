package com.example.markiiimark.batchprocessing.repository

import com.example.markiiimark.batchprocessing.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Integer> {

}