package com.korobeynikova.pr7_primer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private lateinit var start: Button
private lateinit var check: Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ResultProfileBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        start = findViewById(R.id.start)
        check = findViewById(R.id.check)

        check.isEnabled = false

        start.setOnClickListener {
            check.isEnabled = true
            start.isEnabled = false

            generatePrimer()
        }

        check.setOnClickListener {
            check.isEnabled = false
            start.isEnabled = true
        }
    }

    private fun generatePrimer(){

    }
}