package com.example.arithmeticgame

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.arithmeticgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rollButton: Button = findViewById(R.id.RollDieBtn)
        rollButton.setOnClickListener { runGame() }
    }

    private fun runGame() {

        var player = "P1"

        val diceRoll = (1..6).random()

        val diceImage: ImageView = binding.DieImg

        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }

        diceImage.setImageResource(drawableResource)

        if (diceRoll == 1) {

            val problemText: TextView = findViewById(R.id.ProblemText)
            val userAnswer: EditText = findViewById(R.id.editTextNumber)
            val guessButton: Button = findViewById(R.id.GuessBtn)
            val p1Amt: TextView = findViewById(R.id.Player1Amt)

            val num1 = (0..99).random()
            val num2 = (0..99).random()

            val answer = num1 + num2

            problemText.text = "$num1 + $num2 = "


        }// diceRoll = 1 (Addition)
    }
}

