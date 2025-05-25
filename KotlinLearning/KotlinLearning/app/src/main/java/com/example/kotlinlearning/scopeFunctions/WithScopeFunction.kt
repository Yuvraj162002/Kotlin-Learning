package com.example.kotlinlearning.scopeFunctions

import com.example.kotlinlearning.props.User

fun main() {

    val user = User().apply {
        this.age = 12
        this.name = "Smith"
    }

    /**
     * Use of "With" Scope Function.
     *
     * Note:- "With" function is also return the value at end the last line of code is return by default.
     */

    val newUser = with(user) {
        this.age = 25
        this.name = "John"
        age // ---> Here it return the age only.
     // this // ---> here " this" means it return both the age and the name.

    }

    println("New User name is $newUser")

}