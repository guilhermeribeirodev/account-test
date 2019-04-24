package com.example.account.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class AccountHolder(var givenName : String, var surName : String, @Id var idDocument : String) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AccountHolder

        if (idDocument != other.idDocument) return false

        return true
    }

    override fun hashCode(): Int {
        return idDocument.hashCode()
    }
}