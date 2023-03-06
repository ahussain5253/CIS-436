package com.example.arithmeticgame

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.arithmeticgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rollButton: Button = findViewById(R.id.RollDieBtn)
        rollButton.setOnClickListener { runGame() }
    }

    private fun rollDice(): Int {
            val numRolled = (1..6).random()
            val dieImage: ImageView = binding.DieImg
            val drawableResource = when (numRolled) {
                1 -> R.drawable.dice1
                2 -> R.drawable.dice2
                3 -> R.drawable.dice3
                4 -> R.drawable.dice4
                5 -> R.drawable.dice5
                else -> R.drawable.dice6
            }

            dieImage.setImageResource(drawableResource)
            return numRolled
    }

    private fun setProblemText(text: String) {
        val problemText: TextView = binding.ProblemText
        problemText.text = text
    }

    private fun getPlayer1Points(): Int {
        val p1AmtTxt = binding.Player1Amt.text.toString()
        val p1AmtD = p1AmtTxt.toDouble()
        return p1AmtD.toInt()
    }

    private fun getPlayer2Points(): Int {
        val p2AmtTxt = binding.Player2Amt.text.toString()
        val p2AmtD = p2AmtTxt.toDouble()
        return p2AmtD.toInt()
    }

    private fun getJackpotPoints(): Int {
        val jckptTxt = binding.JackpotAmt.text.toString()
        val jckptD = jckptTxt.toDouble()
        return jckptD.toInt()
    }

    private fun setJackpotPoints(jackpotPoints: Int) {
        val jckptTxt: TextView = binding.JackpotAmt
        jckptTxt.text = jackpotPoints.toString()
    }

    private fun setPlayer1Points(player1Points: Int) {
        val player1Amt: TextView = binding.Player1Amt
        player1Amt.text = player1Points.toString()
    }

    private fun setPlayer2Points(player2Points: Int) {
        val player2Amt: TextView = binding.Player2Amt
        player2Amt.text = player2Points.toString()
    }

    private fun runGame() {
        val doublePointsText: TextView = binding.DoublePointsText
        " ".also { doublePointsText.text = it }

        when (rollDice()) {
            1 -> {

                val num1 = (0..99).random()
                val num2 = (0..99).random()
                val answer = num1 + num2

                setProblemText("$num1 + $num2 = ")

                binding.GuessBtn.setOnClickListener {

                    val uAnsTxt = binding.userAnswerEditText.text.toString()
                    val userAnswerD = uAnsTxt.toDouble()
                    val userAnswer = userAnswerD.toInt()

                    if (userAnswer == answer) {
                        setPlayer1Points(getPlayer1Points() + 1)
                    } else {
                        setJackpotPoints(getJackpotPoints() + 1)
                    }
                }
            } // Addition
            2 -> {
                val num1 = (0..99).random()
                val num2 = (0..99).random()
                val answer = num1 - num2

                setProblemText("$num1 - $num2 = ")

                binding.GuessBtn.setOnClickListener {

                    val uAnsTxt = binding.userAnswerEditText.text.toString()
                    val userAnswerD = uAnsTxt.toDouble()
                    val userAnswer = userAnswerD.toInt()

                    if (userAnswer == answer) {
                        setPlayer1Points(getPlayer1Points() + 2)
                    } else {
                        setJackpotPoints(getJackpotPoints() + 2)
                    }
                }
            } // Subtraction
            3 -> {
                val num1 = (0..20).random()
                val num2 = (0..20).random()
                val answer = num1 * num2

                setProblemText("$num1 x $num2 = ")

                binding.GuessBtn.setOnClickListener {

                    val uAnsTxt = binding.userAnswerEditText.text.toString()
                    val userAnswerD = uAnsTxt.toDouble()
                    val userAnswer = userAnswerD.toInt()

                    if (userAnswer == answer) {
                        setPlayer1Points(getPlayer1Points() + 3)
                    } else {
                        setJackpotPoints(getJackpotPoints() + 3)
                    }


                }
            } // Multiplication
            4 -> {
                when ((1..3).random()) {
                    1 -> {
                        "Double Points! (+2) ".also { doublePointsText.text = it }
                        val num1 = (0..99).random()
                        val num2 = (0..99).random()
                        val answer = num1 + num2

                        setProblemText("$num1 + $num2 = ")

                        binding.GuessBtn.setOnClickListener {

                            val uAnsTxt = binding.userAnswerEditText.text.toString()
                            val userAnswerD = uAnsTxt.toDouble()
                            val userAnswer = userAnswerD.toInt()

                            if (userAnswer == answer) {
                                setPlayer1Points(getPlayer1Points() + 2)
                            } else {
                                setJackpotPoints(getJackpotPoints() + 2)
                            }
                        }
                    } // Addition
                    2 -> {
                        "Double Points! (+4) ".also { doublePointsText.text = it }
                        val num1 = (0..99).random()
                        val num2 = (0..99).random()
                        val answer = num1 - num2

                        setProblemText("$num1 - $num2 = ")

                        binding.GuessBtn.setOnClickListener {

                            val uAnsTxt = binding.userAnswerEditText.text.toString()
                            val userAnswerD = uAnsTxt.toDouble()
                            val userAnswer = userAnswerD.toInt()

                            if (userAnswer == answer) {
                                setPlayer1Points(getPlayer1Points() + 4)
                            } else {
                                setJackpotPoints(getJackpotPoints() + 4)
                            }
                        }
                    } // Subtraction
                    3 -> {
                        "Double Points! (+6) ".also { doublePointsText.text = it }
                        val num1 = (0..20).random()
                        val num2 = (0..20).random()
                        val answer = num1 * num2

                        setProblemText("$num1 x $num2 = ")

                        binding.GuessBtn.setOnClickListener {

                            val uAnsTxt = binding.userAnswerEditText.text.toString()
                            val userAnswerD = uAnsTxt.toDouble()
                            val userAnswer = userAnswerD.toInt()

                            if (userAnswer == answer) {
                                setPlayer1Points(getPlayer1Points() + 6)
                            } else {
                                setJackpotPoints(getJackpotPoints() + 6)
                            }
                        }
                    } // Multiplication
                }
            } // Double Points
        } // Roll Dice
    } // Run Game
}


