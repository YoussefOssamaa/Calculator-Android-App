package com.KOtlin.first_android_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() , View.OnClickListener {

    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMul : Button
    lateinit var btnDiv : Button
    lateinit var et1 : EditText
    lateinit var et2 : EditText
    lateinit var ResultTv : TextView
    lateinit var warningTv : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd = findViewById(R.id.addButton)
        btnSub = findViewById(R.id.subButton)
        btnMul = findViewById(R.id.mulButton)
        btnDiv = findViewById(R.id.divButton)
        et1 = findViewById(R.id.editText1)
        et2 = findViewById(R.id.editText2)
        ResultTv = findViewById(R.id.result_id)


        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMul.setOnClickListener(this)
        btnDiv.setOnClickListener(this)


    }

    override fun onClick(v: View?) {

        var stringToken :String
        var errorflag : Boolean = false
        var a = 0.0
        var b = 0.0
        var result : Double? = 0.0

        stringToken = et1.text.toString()
        if (stringToken.isNotEmpty()){
            try {
                 a  = stringToken.toDouble()
            }
            catch (e : NumberFormatException){
                errorflag = true
            }
        }else{
            errorflag = true
        }




        stringToken = et2.text.toString()

        if (stringToken.isNotEmpty()){
            try {
                b  = stringToken.toDouble()
            }
            catch (e : NumberFormatException){
                errorflag = true           }
        }else{
            errorflag = true
        }





        if ( errorflag == false)
        {

            when (v?.id) {

                R.id.addButton -> {
                    result = a.toDouble() + b.toDouble()
                }

                R.id.subButton -> {
                    result = a - b
                }

                R.id.mulButton -> {
                    result = a * b
                }

                R.id.divButton -> {
                    result = a / b
                }

            }
            ResultTv.text = "The Result is : $result"

        }
        else {
            ResultTv.text = "Please Enter 2 Numbers"
        }

    }

}