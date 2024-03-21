package com.korobeynikova.pr7_primer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.korobeynikova.pr7_primer.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var right = 0
    private var lose = 0
    private var all = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.check.isEnabled = false
        binding.vvod.isEnabled = false

        binding.start.setOnClickListener {
            binding.check.isEnabled = true
            binding.start.isEnabled = false
            binding.vvod.isEnabled = true

            generatePrimer()
        }

        binding.check.setOnClickListener {
            binding.check.isEnabled = false
            binding.start.isEnabled = true
            binding.vvod.isEnabled = false

            checkPrimer()
        }
    }
    private fun generateRandomOperand(): Int {
        return Random.nextInt(10, 100)
    }

    private fun generateRandomOperator(): Char {
        val operators = listOf('*', '/', '-', '+')
        return operators.random()
    }
    private fun generatePrimer(){
        binding.nullNull1.text = generateRandomOperand().toString()
        binding.nullNull2.text = generateRandomOperand().toString()
        binding.znak.text = generateRandomOperator().toString()
    }
    private fun checkPrimer(){
        val numberOne = binding.nullNull1.text.toString().toInt()
        val numberYwo = binding.nullNull2.text.toString().toInt()

        val result = when (binding.znak.text) {
            "+" -> numberOne + numberYwo
            "-" -> numberOne - numberYwo
            "*" -> numberOne * numberYwo
            "/" -> numberOne / numberYwo
            else -> throw IllegalArgumentException("Unknown operator")
        }

        if (result == binding.vvod.text.toString().toInt()){
            right++
        }
        else{
            lose++
        }
        all++
        val present = String.format("%.2f%%", (right.toDouble() / all.toDouble()) * 100)
        binding.null1.text = all.toString()
        binding.null2.text = right.toString()
        binding.null3.text = lose.toString()
        binding.prosenttext.text = present
    }
}