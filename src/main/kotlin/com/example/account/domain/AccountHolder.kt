package com.example.account.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class AccountHolder(var name : String, var sortCode : String, @Id var accNumber : String) {
}