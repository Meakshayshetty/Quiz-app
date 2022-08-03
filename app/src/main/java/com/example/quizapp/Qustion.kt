package com.example.quizapp

data class Qustion(
    val id:Int,
    val Question: String,
    val image: Int,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    val correctAnswer :Int
)
