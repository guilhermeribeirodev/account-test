package com.example.account.resource.param

import com.example.account.domain.Account
import java.math.BigDecimal

class TransferParam(var fromAcc : String, var toAcc : String, var ammount : BigDecimal) {
    constructor(fromAcc: Account, toAcc: Account, ammount: BigDecimal) : this(fromAcc.accNumber, toAcc.accNumber, ammount)
}