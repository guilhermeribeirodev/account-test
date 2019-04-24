package com.example.account.domain

import lombok.Builder
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity @Builder
class Account(var sortCode : String, @Id var accNumber : String, var balance : BigDecimal) {

    @OneToOne
    lateinit var accountHolder : AccountHolder

    fun setUpHolder(accountHolder: AccountHolder) : Account {
        this.accountHolder = accountHolder
        return this
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Account

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