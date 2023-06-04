package com.example.ktorm.model

import org.ktorm.database.Database
import org.ktorm.entity.Entity
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

/**
 * The employee entity.
 */
interface User : Entity<User> {
    companion object : Entity.Factory<User>()

    /**
     * Employee ID.
     */
    var id: Int

    /**
     * The employee's name.
     */
    var name: String

    /**
     * The employee's job.
     */
    var job: String

    /**
     * The employee's job.
     */
    var age: Int
}

object Users : Table<User>("user") {

    /**
     * Employee ID.
     */
    val id = int("id").primaryKey().bindTo { it.id }

    /**
     * The employee's name.
     */
    val name = varchar("name").bindTo { it.name }

    /**
     * The employee's job.
     */
    val age = int("age").bindTo { it.age }
}

val Database.user get() = this.sequenceOf(Users)