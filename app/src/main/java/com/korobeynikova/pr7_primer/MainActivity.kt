package com.korobeynikova.pr7_primer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

private lateinit var start: Button
private lateinit var check: Button

private lateinit var null1: TextView
private lateinit var null2: TextView
private lateinit var znak: TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        start = findViewById(R.id.start)
        check = findViewById(R.id.check)

        null1 = findViewById(R.id.null_null_1)
        null2 = findViewById(R.id.null_null_2)
        znak = findViewById(R.id.znak)

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

    fun generateRandomOperand(): Int {
        return Random.nextInt(10, 100)
    }

    fun generateRandomOperator(): Char {
        val operators = listOf('*', '/', '-', '+')
        return operators.random()
    }
    private fun generatePrimer(){
        null1.text = generateRandomOperand().toString()
        null2.text = generateRandomOperand().toString()
        znak.text = generateRandomOperator().toString()
    }
}