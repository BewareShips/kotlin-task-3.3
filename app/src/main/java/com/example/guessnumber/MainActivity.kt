package com.example.guessnumber

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager.LayoutParams.*
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var guessInputNumber: EditText
    lateinit var validateBtn: Button
    lateinit var guessBtn: Button
    var guessNumber:Int = 0;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        guessInputNumber = findViewById(R.id.guessInputNumber)
        validateBtn = findViewById(R.id.submitBtn)
        guessBtn = findViewById(R.id.guessBtn)


//        val params = textView.getLayoutParams()

        textView.text = "Please enter you guess"

        guessBtn.setOnClickListener {
            guessNumber = guessInputNumber.text.toString().toInt()
            guessInputNumber.text.clear()
            guessInputNumber.visibility = View.GONE
            guessBtn.visibility = View.GONE
//            params.height = 0;
//            textView.setLayoutParams(params);
            closeKeyboard()
        }

        validateBtn.setOnClickListener {
            val number: Int = editText.text.toString().toInt()
            if(number < guessNumber){
                textView.text = "You number is higher"
                editText.text.clear()
            }else if(number > guessNumber){
                textView.text = "You number is lower"
                editText.text.clear()
            }else{
                textView.text = "You was right"
                guessInputNumber.visibility = View.VISIBLE
                guessBtn.visibility = View.VISIBLE
            }
            closeKeyboard()
        }

    }

    private fun closeKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val hideMe =  getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            hideMe.hideSoftInputFromWindow(view.windowToken,0)
        }
        window.setSoftInputMode(SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }
}