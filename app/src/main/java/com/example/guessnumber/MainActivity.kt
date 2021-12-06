package com.example.guessnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var guessInputNumber: EditText
    lateinit var validateBtn: Button
    lateinit var guessBtn: Button
    var guessNumber:Int = 0;

    var random:Int = nextInt(1,1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        guessInputNumber = findViewById(R.id.guessInputNumber)
        validateBtn = findViewById(R.id.submitBtn)
        guessBtn = findViewById(R.id.guessBtn)





        textView.text = "Please enter you guess"

        guessBtn.setOnClickListener {
            guessNumber = guessInputNumber.text.toString().toInt()
            guessInputNumber.text.clear()
        }

        validateBtn.setOnClickListener {
            val number: Int = editText.text.toString().toInt()
            if(number < guessNumber){
                textView.text = "You number is higher"
                editText.text.clear()
            }else if(number > random){
                textView.text = "You number is lower"
                editText.text.clear()
            }else{
                textView.text = "You was right"
            }
        }
    }
}