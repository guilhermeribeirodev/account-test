package com.example.account.holder.repo

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
@ActiveProfiles("test")
class AccountHolderRepoTest {


    private val LOGGER = LoggerFactory.getLogger(javaClass)

    @Test
    fun firstTest() {
        assertThat(true, `is`(true))
        LOGGER.info("test passes")
    }


}