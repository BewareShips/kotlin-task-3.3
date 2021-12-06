package com.example.guessnumber

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager.LayoutParams.*
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var guessInputNumber: EditText
    lateinit var guessBtn: Button
    var guessNumber:Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        guessInputNumber = findViewById(R.id.guessInputNumber)
        guessBtn = findViewById(R.id.guessBtn)

        guessBtn.setOnClickListener {
            guessNumber = guessInputNumber.text.toString().toInt()


            //guessInputNumber.text.clear()
            //closeKeyboard()
            var newScreenIntent = Intent(this, GuessActivity::class.java)
            newScreenIntent.putExtra("number",guessNumber)
            startActivity(newScreenIntent)
        }
    }

    private fun closeKeyboard() {
        val view = this.currentFocus;
        if (view != null) {
            val hideMe =  getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            hideMe.hideSoftInputFromWindow(view.windowToken,0)
        }
        window.setSoftInputMode(SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }
}