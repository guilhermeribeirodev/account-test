package com.example.account.repository

import com.example.account.domain.AccountHolder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface AccountHolderRepo : JpaRepository<AccountHolder, BigInteger> {
}