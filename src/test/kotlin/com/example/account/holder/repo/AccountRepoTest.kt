package com.example.account.holder.repo

import com.example.account.domain.Account
import com.example.account.repository.AccountRepo
import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is
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
class AccountRepoTest {

    private val LOGGER = LoggerFactory.getLogger(javaClass)

    private lateinit var stubbedAccount : Account

    @Autowired
    lateinit var repository : AccountRepo

    @Before
    fun setUp() {
        stubbedAccount = Account()
    }

    @Test
    fun itShouldCreateAValidAccountHolder() {
        MatcherAssert.assertThat(repository.save(Account()), Is.`is`(stubbedAccount))
        LOGGER.info("test passes")
    }
}