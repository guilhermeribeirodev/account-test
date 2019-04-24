package com.example.account.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class AccountHolder(var name : String, var sortCode : String, @Id var accNumber : String) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AccountHolder

        if (sortCode != other.sortCode) return false
        if (accNumber != other.accNumber) return false

        return true
    }

    override fun hashCode(): Int {
        var result = sortCode.hashCode()
        result = 31 * result + accNumber.hashCode()
        return result
    }
}