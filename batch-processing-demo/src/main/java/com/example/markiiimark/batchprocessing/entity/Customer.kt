package com.example.markiiimark.batchprocessing.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import java.io.Serializable

@Entity
@Table(name="CUSTOMERS_INFO")
data class Customer(
    @Id @Column(name = "CUSTOMER_ID") var id: Int,
    @Column(name = "FIRST_NAME") var firstName: String = "",
    @Column(name = "LAST_NAME") var lastName: String = "",
    @Column(name = "EMAIL") var email: String = "",
    @Column(name = "GENDER") var gender: String = "",
    @Column(name = "CONTACT") var contactNo: String = "",
    @Column(name = "COUNTRY") var country: String = "",
    @Column(name = "DOB") var dob: String = "",
): Serializable {

}