package com.example.kotlinlearning.conditionsLearning.forEachLoopQuestion

fun main(){

    // Question: Count how many numbers between 1 and 50 are divisible by 3.

    var countOf3 = 0
    for (i in 1..50) {
        if (i % 3 == 0) {
            countOf3++
        }
    }
    println("value of the count is $countOf3")

    // Question: Print the factorial of a given number (e.g., 5! = 5 * 4 * 3 * 2 * 1).

    val num = 5
    var sum = 1

    for (i in num downTo 1){
        sum *= i
    }
    println("sum of the factorial is $sum")

    // Question: Print the first 10 Fibonacci numbers( The Fibonacci series is a sequence of numbers where each number is the sum of the two preceding ones. It starts with 0 and 1 by default. using a for loop.)

    var firstNum = 0
    var secondNum = 1
    val fiboLimit = 10
    var fiboSum = 0

    print("fibonacci series is $firstNum \t $secondNum \t")

    for (i in 2 until fiboLimit) {
        fiboSum = firstNum + secondNum
        print("$fiboSum \t")
        firstNum = secondNum
        secondNum = fiboSum
    }
}