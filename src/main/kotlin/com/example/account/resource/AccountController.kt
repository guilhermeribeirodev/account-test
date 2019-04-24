package com.example.account.resource

import com.example.account.domain.Account
import com.example.account.domain.AccountHolder
import com.example.account.resource.param.TransferParam
import com.example.account.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/api/account")
class AccountController {

    @Autowired
    private lateinit var accountService : AccountService

    @PostMapping
    fun createAccount(@RequestBody accountHolder : AccountHolder) : Account {

        return accountService.createAccount(accountHolder)
    }

    @PostMapping("transfer")
    fun transferFromToAccount(@RequestBody transferParam : TransferParam) : Account {

        return accountService.transfer(transferParam)
    }
}