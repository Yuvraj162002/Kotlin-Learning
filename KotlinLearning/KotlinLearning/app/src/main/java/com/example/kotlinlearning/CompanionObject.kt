package com.example.kotlinlearning


fun main() {

    // Here without companion object we cannot access the value and function directly,
    // for this we need to create the instance of the class like object of class ( className() ).
    println("Without companion object value is ${CompanionObject().withoutCompanion} " +
            "and  ${CompanionObject().withoutCompanionFunction(a= 12, b = 13)}")


    // Here For the companion object we can access the value and function directly
    println("With companion object value i1s ${CompanionObject.WITH_COMPANION} " +
            "and ${CompanionObject.withCompanionFunction(a= 12, b = 13)}")
}
class CompanionObject {

    val withoutCompanion = 12

    fun withoutCompanionFunction(a:Int, b:Int):Int {
        return a+b
    }

    companion object NewOne{
          const val WITH_COMPANION = 12

        fun withCompanionFunction(a:Int, b:Int):Int {
            return a+b
        }
    }
}