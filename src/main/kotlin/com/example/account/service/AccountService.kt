package com.example.account.service

import com.example.account.domain.Account
import com.example.account.domain.AccountHolder
import com.example.account.repository.AccountRepo
import com.example.account.resource.param.TransferParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import javax.transaction.Transactional

@Service
@Transactional
class AccountService {

    @Autowired
    private  lateinit var accountRepo : AccountRepo

    fun createAccount(accountHolder: AccountHolder): Account {

        return accountRepo.save(Account("generatedSortCode", "generatedAccNumber", BigDecimal.ZERO))
                .setUpHolder(accountHolder)
    }

    fun transfer(transferParam: TransferParam): Account {

        val fromAccount : Account = accountRepo.findByAccNumber(transferParam.fromAcc);
        val toAccount : Account = accountRepo.findByAccNumber(transferParam.toAcc);

        toAccount.deposit(fromAccount.withdraw(transferParam.ammount).balance - transferParam.ammount)

        accountRepo.save(fromAccount)
        accountRepo.save(toAccount)

        return fromAccount
    }
}