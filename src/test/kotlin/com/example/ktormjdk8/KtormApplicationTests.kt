package com.example.ktormjdk8

import com.example.ktorm.model.Users
import com.example.ktorm.model.user
import org.junit.jupiter.api.Test
import org.ktorm.database.Database
import org.ktorm.dsl.from
import org.ktorm.dsl.limit
import org.ktorm.dsl.select
import org.ktorm.entity.first
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KtormApplicationTests {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(KtormApplicationTests::class.java)
    }

    @Autowired
    lateinit var database: Database

    @Test
    fun contextLoads() {

        var select = database.from(Users).select()


        for (queryRowSet in select) {
			println(queryRowSet[Users.id])
			println(queryRowSet[Users.name])
			println(queryRowSet[Users.age])
            println("")
        }

        var first = database.user.first()
        println(first)


        var query = database.from(Users).select().limit(50, 10)
		println("==========")
		var totalRecordsInAllPages = query.totalRecordsInAllPages
		println(query.rowSet.size())
		for (rowSet in query) {
			println(rowSet[Users.id])
			println(rowSet[Users.name])
			println(rowSet[Users.age])
			println("")
        }
		println("==========")

        try {
            throw RuntimeException("aaa")
        }catch (e : Exception){
            LOGGER.error(e.message,e)
        }


    }

}
