package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var valueMoney = 0;
    var valueGroupNumber = 2;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editTextValue.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                try {
                    valueMoney = Integer.parseInt(s.toString());
                }
                catch (e: Exception){
                    valueMoney = 0
                }
                finally {
                    textViewResult.text = calculate_final_value().toString()
                }
            }
        })

        editTextGroupNumber.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                try {
                    valueGroupNumber = Integer.parseInt(s.toString());
                }
                catch (e: Exception){
                    valueGroupNumber = 0
                }
                finally {
                    textViewResult.text = calculate_final_value().toString()
                }
            }
        })
    }

    fun calculate_final_value(): Int {
        val _v1 = valueMoney?: 0
        val _v2 = valueGroupNumber?: 1

        return valueMoney / valueGroupNumber
    }
}