package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      val etname :EditText = findViewById(R.id.etname)
        val btnstart :Button= findViewById(R.id.btnstart)
        btnstart.setOnClickListener {
            if(etname.text.isEmpty()){
                Toast.makeText(this,"please enter your name", Toast.LENGTH_LONG).show()
            }else{
                val intent= Intent(this,QuizquestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME,etname.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}