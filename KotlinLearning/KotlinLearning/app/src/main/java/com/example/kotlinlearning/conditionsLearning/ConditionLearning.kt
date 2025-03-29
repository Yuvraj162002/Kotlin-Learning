package com.example.kotlinlearning.conditionsLearning


// Learn about For and ForEach loop.
class MainClass {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Hello, World!")

            /**Print value from 1 to 5. -------> Example 1**/

//            for (i in 1..5) {
//                println("Print value from 1 to 5 is $i")
//            }

            /**Print value from 1 to 5 but 5 not including.-------> Example 2**/

//            for (i in 0 until 5){
//                println("Print value from 1 to 5,but not include 5 is $i")
//            }

            /**Print value from 5 to 1( opposite side).-------> Example 3**/

//            for (i in 5 downTo 1){
//                println("Print value from 5 to 1 is $i")
//            }

            /**Print value from 1 to 5 but step by 2.-------> Example 4**/

//            for (i in 0..5 step 2){
//                println("Print value from 1 to 5 but step by 2 is $i")
//            }


            /**Print value for the ForEach Loop.-------> Example 5**/

            val listAre = listOf("A", "B", "C", "D", "E")
            listAre.forEach{list ->
                println("List in the list of is $list")

            }

        }
    }
}