package com.example.account.resource

import com.example.account.domain.Account
import com.example.account.domain.AccountHolder
import com.example.account.resource.param.TransferParam
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.math.BigDecimal


@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class AccountResourceTest {

    @Autowired
    private lateinit var mockMvc: MockMvc


    @Before
    fun setUp() {

    }

    @Test
    fun createAccount() {
        val accountHolder = AccountHolder("name","sortCode","accNumber")
        val jsonData = jacksonObjectMapper().writeValueAsString(accountHolder)


        mockMvc.perform(MockMvcRequestBuilders.post("/api/account/").contentType(MediaType.APPLICATION_JSON).content(jsonData))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
    }

    @Test
    fun transferBetweenAccounts() {

        val resultAlice : MvcResult = createAccount(AccountHolder("Alice","sortCode","abc1234"))
        val resultBob : MvcResult = createAccount(AccountHolder("Bob","sortCode","def5678"))

        val accountAlice : Account = jacksonObjectMapper().readValue(resultAlice.getResponse().getContentAsString(), Account::class.java)
        val accountBob = jacksonObjectMapper().readValue(resultBob.getResponse().getContentAsString(), Account::class.java)

        val transferParam = TransferParam(accountAlice, accountBob, BigDecimal("10"))

        val jsonDataParam = jacksonObjectMapper().writeValueAsString(transferParam)

        mockMvc.perform(MockMvcRequestBuilders.post("/api/account/transfer").contentType(MediaType.APPLICATION_JSON).content(jsonDataParam))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
    }

    private fun createAccount(accountHolder : AccountHolder) : MvcResult{

        val jsonData_1 = jacksonObjectMapper().writeValueAsString(accountHolder)

        return  mockMvc.perform(MockMvcRequestBuilders.post("/api/account/").contentType(MediaType.APPLICATION_JSON).content(jsonData_1))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andDo(MockMvcResultHandlers.print())
                .andReturn()

    }
}