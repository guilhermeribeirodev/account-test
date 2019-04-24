package com.example.account.service

import com.example.account.domain.Account
import com.example.account.domain.AccountHolder
import com.example.account.repository.AccountRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class AccountService {

    @Autowired
    private  lateinit var accountRepo : AccountRepo

    fun createAccount(accountHolder: AccountHolder): Account {

        return accountRepo.save(Account("generatedSortCode", "generatedAccNumber", BigDecimal.ZERO))
                .setUpHolder(accountHolder)
    }
}