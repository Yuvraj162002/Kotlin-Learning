package com.example.kotlinlearning.conditionsLearning.forEachLoopQuestion


fun main() {

    // Question: Write a program to print numbers from 1 to 10 using a for loop.
    for (i in 1..10) {
        println("Number is $i")
    }

    // Question: Write a program to print even numbers from 1 to 20 using a for loop.

    for(i in 1..20) {
        if(i % 2 == 0) {
            println("Even number is $i")
        }
    }
    // Question: Write a program to print the multiplication table of 5 using a for loop.

    for (i in 1..10) {
        println("5 x $i = ${5 * i}")
    }

    // Question: Print numbers from 10 to 1 in reverse order.

    for (i in 10 downTo 1) {
        println("Number in reverse order is $i")
    }

    // Question: Iterate through an array of names (["Alice", "Bob", "Charlie"]) and print each name.

    val array:ArrayList<String> = arrayListOf("Alice", "Bob", "Charlie")

    for ( name in  array) {
        println("Name is $name")
    }
}