package com.example.account.domain

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Account(var sortCode : String, @Id var accNumber : String, var balance : BigDecimal) {
}