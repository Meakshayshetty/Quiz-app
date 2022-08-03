package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvName:TextView =findViewById(R.id.tvname)
        val tvscore :TextView =findViewById(R.id.tvscore)
        val btnFinish: Button =findViewById(R.id.btnFinish)

        tvName.text= intent.getStringExtra(Constants.USER_NAME)
        val totalQuestion =intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswer =intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tvscore.text ="Your Score is $correctAnswer out of $totalQuestion "

        btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}