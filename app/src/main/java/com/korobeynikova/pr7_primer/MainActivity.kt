package com.korobeynikova.pr7_primer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.korobeynikova.pr7_primer.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.check.isEnabled = false

        binding.start.setOnClickListener {
            binding.check.isEnabled = true
            binding.start.isEnabled = false

            generatePrimer()
        }

        binding.check.setOnClickListener {
            binding.check.isEnabled = false
            binding.start.isEnabled = true
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
}