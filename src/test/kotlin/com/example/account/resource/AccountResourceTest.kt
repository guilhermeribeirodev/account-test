package com.example.account.resource

import com.example.account.domain.AccountHolder
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.boot.test.web.client.TestRestTemplate




@RunWith(SpringRunner::class)
//@WebMvcTest(AccountController::class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class AccountResourceTest {

    @Autowired
    private lateinit var mockMvc: MockMvc


    @Before
    fun setUp() {
        //mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    fun createAccount() {
        var accountHolder = AccountHolder("name","sortCode","accNumber")
        var jsonData = jacksonObjectMapper().writeValueAsString(accountHolder)


        mockMvc.perform(MockMvcRequestBuilders.post("/api/account/").contentType(MediaType.APPLICATION_JSON).content(jsonData))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
    }
}