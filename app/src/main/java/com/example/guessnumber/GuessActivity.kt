package com.example.guessnumber

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class GuessActivity : AppCompatActivity() {


    lateinit var textView: TextView
    lateinit var numberAnswer: TextView
    lateinit var editText: EditText
    lateinit var validateBtn: Button
    lateinit var returnToMainBtn: Button

    var guessNumber:Int = 0;

    var currentAttempts:Int = 0
    var totalAttempts:Int  = 12


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        validateBtn = findViewById(R.id.submitBtn)

        returnToMainBtn = findViewById(R.id. returnToMainBtn)
        numberAnswer = findViewById(R.id.numberAnswer)




        val mIntent = intent
        guessNumber= mIntent.getIntExtra("number", 0)

        returnToMainBtn.visibility = View.GONE
        numberAnswer.visibility = View.GONE


        textView.text = "Please enter you guess"

        validateBtn.setOnClickListener {
            currentAttempts++
            val number: Int = editText.text.toString().toInt()

           if(totalAttempts >= currentAttempts ){
               if(number < guessNumber){
                   textView.text = "You number is higher"
                   editText.text.clear()
               }else if(number > guessNumber){
                   textView.text = "You number is lower"
                   editText.text.clear()
               }else{
                   //val spannableString = SpannableString("$guessNumber was a guessed number")
//                   val sizeSpan = RelativeSizeSpan(2f)
//                   spannableString.setSpan(sizeSpan,0,1,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    numberAnswer.text = "$guessNumber"
                   numberAnswer.setTextColor(Color.parseColor("#00FF00"))
                   textView.text = " was a guessed number"
                   validateBtn.visibility = View.GONE
                   returnToMainBtn.visibility = View.VISIBLE
                   numberAnswer.visibility = View.VISIBLE
               }
               closeKeyboard()
           }else{
               validateBtn.visibility = View.GONE
               returnToMainBtn.visibility = View.VISIBLE
               numberAnswer.visibility = View.VISIBLE
               numberAnswer.text = "$guessNumber"
               numberAnswer.setTextColor(Color.parseColor("##FF0000"))
               textView.text = " was a guessed number"
           }
        }
        returnToMainBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun closeKeyboard() {
        val view = this.currentFocus;
        if (view != null) {
            val hideMe =  getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            hideMe.hideSoftInputFromWindow(view.windowToken,0)
        }
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

    private fun onResult(message: String,color:String){

    }


}




