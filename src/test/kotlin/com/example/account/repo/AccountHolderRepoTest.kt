package com.example.account.repo

import com.example.account.domain.AccountHolder
import com.example.account.repository.AccountHolderRepo
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
@ActiveProfiles("test")
class AccountHolderRepoTest {


    private val LOGGER = LoggerFactory.getLogger(javaClass)

    private lateinit var stubbedAccountHolder : AccountHolder

    @Autowired
    lateinit var repository : AccountHolderRepo

    @Before
    fun setUp() {
        stubbedAccountHolder = AccountHolder("name","sortCode","accNumber")
    }

    @Test
    fun itShouldCreateAValidAccountHolder() {
        assertThat(repository.save(AccountHolder("name","sortCode","accNumber")), `is`(stubbedAccountHolder))
        LOGGER.info("test passes")
    }

}