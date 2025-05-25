package com.example.kotlinlearning.scopeFunctions

import com.example.kotlinlearning.props.User

fun main() {

    val user: User? = null

    /**
     * Use of "Run" Scope Function
     *
     * Note:- "Run" function is used to check the nullability of the object and also return some value as end.
     *
     * "RUN" -> "Let" + "With"
     */

    val runUser = user?.run { // --> Here is give yellow line because it already then this (user) is the null so the code insdie this not execute.
        println("length of the name is ${this.name.length}")
        this.age
    }
    println("User name is $runUser")


    val newUser = User().apply {
        this.age = 12
        this.name = "Smith"
    }

    val newRunUser = newUser.run {
        this.age = 12
        this.name = "Smith"
        age
    }

    println("New User name is $newRunUser")


}