package com.hindu.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val entered_name :EditText=findViewById(R.id.entered_name)
        val btn_start :Button = findViewById(R.id.btn_start)
        btn_start.setOnClickListener {
            if(entered_name.text.isEmpty() )
            {
                Toast.makeText(this,"Please enter your name" , Toast.LENGTH_LONG).show()
            }else
            {
                val intent = Intent(this, QuizQuestions::class.java)
                intent.putExtra(Constants.USER_NAME , entered_name.text.toString())
                startActivity(intent)
                finish()
            }


        }
    }
}