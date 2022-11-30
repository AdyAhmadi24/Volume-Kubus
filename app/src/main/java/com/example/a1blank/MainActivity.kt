package com.example.a1blank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var edtWidth: EditText
    private lateinit var btn1: Button
    private lateinit var result: TextView

    companion object {
        private const val STATE_RESULT = "state_result"

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtHeight = findViewById(R.id.edtHeight)
        edtLength = findViewById(R.id.edtLength)
        edtWidth = findViewById(R.id.edtWidth)
        btn1 = findViewById(R.id.btn1)
        result = findViewById(R.id.result)

        btn1.setOnClickListener(this)

        if (savedInstanceState !=null){
            val resultt = savedInstanceState.getString(STATE_RESULT)
            result.text = resultt
    }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, result.text.toString())
    }
    override fun onClick(v: View?) {
        if (v?.id == R.id.btn1) {
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var empty = false

            if (inputLength.isEmpty()) {
                empty = true
                edtLength.error = "Tidak boleh kosong"
            }

            if (inputHeight.isEmpty()) {
                empty = true
                edtHeight.error = "Tidak boleh kosong"
            }

            if (inputWidth.isEmpty()) {
                empty = true
                edtWidth.error = "Tidak boleh kosong"
            }

            if (!empty) {

                val volume = inputLength.toDouble() * inputHeight.toDouble() * inputWidth.toDouble()
                result.text = volume.toString()
            }
        }

    }
}

