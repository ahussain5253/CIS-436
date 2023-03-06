package com.example.arithmeticgame

import android.os.Bundle
import android.view.View
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

        var currentPlayer = 1
        binding.playAgain.visibility = View.INVISIBLE

        val rollButton: Button = findViewById(R.id.RollDieBtn)
        rollButton.setOnClickListener {
            val playerText: TextView = binding.CurrentPlayer

            if (getPlayer1Points() >= 20) {
                binding.playAgain.visibility = View.VISIBLE
                setProblemText("Player 1 Wins!!")
                binding.GuessBtn.visibility = View.INVISIBLE
                binding.playAgain.setOnClickListener {
                    playAgain()
                }
            }
            else if (getPlayer2Points() >= 20) {
                binding.playAgain.visibility = View.VISIBLE
                setProblemText("Player 2 Wins!!")
                binding.GuessBtn.visibility = View.INVISIBLE
                binding.playAgain.setOnClickListener {
                    playAgain()
                }
            }

            binding.playAgain.visibility = View.INVISIBLE

            when (currentPlayer) {
                1 -> {
                    "P1".also { playerText.text = it }
                    runGame(1)}
                2 -> {
                    "P2".also { playerText.text = it }
                    runGame(2)}
            }

            when (currentPlayer) {
                1 -> currentPlayer = 2
                2 -> currentPlayer = 1
            }
        }
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

    private fun playAgain() {
        setProblemText("Ready?")
        setPlayer1Points(0)
        setPlayer2Points(0)
        setJackpotPoints(5)
    }

    private fun runGame(currentPlayer: Int) {
        val doublePointsText: TextView = binding.DoublePointsText
        " ".also { doublePointsText.text = it }
        binding.GuessBtn.visibility = View.VISIBLE

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

                    if ((userAnswer == answer) && (currentPlayer == 1)) {
                        setPlayer1Points(getPlayer1Points() + 1)
                        "Correct!".also { doublePointsText.text = it }
                    } else if ((userAnswer == answer) && (currentPlayer == 2)) {
                        setPlayer2Points(getPlayer2Points() + 1)
                        "Correct!".also { doublePointsText.text = it }
                    } else if (userAnswer != answer) {
                        setJackpotPoints(getJackpotPoints() + 1)
                        "Incorrect!".also { doublePointsText.text = it }
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

                    if ((userAnswer == answer) && (currentPlayer == 1)) {
                        setPlayer1Points(getPlayer1Points() + 2)
                        "Correct!".also { doublePointsText.text = it }
                    } else if ((userAnswer == answer) && (currentPlayer == 2)) {
                        setPlayer2Points(getPlayer2Points() + 2)
                        "Correct!".also { doublePointsText.text = it }
                    } else if (userAnswer != answer) {
                        setJackpotPoints(getJackpotPoints() + 2)
                        "Incorrect!".also { doublePointsText.text = it }
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

                    if ((userAnswer == answer) && (currentPlayer == 1)) {
                        setPlayer1Points(getPlayer1Points() + 3)
                        "Correct!".also { doublePointsText.text = it }
                    } else if ((userAnswer == answer) && (currentPlayer == 2)) {
                        setPlayer2Points(getPlayer2Points() + 3)
                        "Correct!".also { doublePointsText.text = it }
                    } else if (userAnswer != answer) {
                        setJackpotPoints(getJackpotPoints() + 3)
                        "Incorrect!".also { doublePointsText.text = it }
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

                            if ((userAnswer == answer) && (currentPlayer == 1)) {
                                setPlayer1Points(getPlayer1Points() + 2)
                                "Correct!".also { doublePointsText.text = it }
                            } else if ((userAnswer == answer) && (currentPlayer == 2)) {
                                setPlayer2Points(getPlayer2Points() + 2)
                                "Correct!".also { doublePointsText.text = it }
                            } else if (userAnswer != answer) {
                                setJackpotPoints(getJackpotPoints() + 2)
                                "Incorrect!".also { doublePointsText.text = it }
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

                            if ((userAnswer == answer) && (currentPlayer == 1)) {
                                setPlayer1Points(getPlayer1Points() + 4)
                                "Correct!".also { doublePointsText.text = it }
                            } else if ((userAnswer == answer) && (currentPlayer == 2)) {
                                setPlayer2Points(getPlayer2Points() + 4)
                                "Correct!".also { doublePointsText.text = it }
                            } else if (userAnswer != answer) {
                                setJackpotPoints(getJackpotPoints() + 4)
                                "Incorrect!".also { doublePointsText.text = it }
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

                            if ((userAnswer == answer) && (currentPlayer == 1)) {
                                setPlayer1Points(getPlayer1Points() + 6)
                                "Correct!".also { doublePointsText.text = it }
                            } else if ((userAnswer == answer) && (currentPlayer == 2)) {
                                setPlayer2Points(getPlayer2Points() + 6)
                                "Correct!".also { doublePointsText.text = it }
                            } else if (userAnswer != answer) {
                                setJackpotPoints(getJackpotPoints() + 6)
                                "Incorrect!".also { doublePointsText.text = it }
                            }
                        }
                    } // Multiplication
                }
            } // Double Points
            5 -> {
                setProblemText("You lost a turn! Next player rolls!")
                binding.GuessBtn.visibility = View.INVISIBLE
            } // Lose a Turn
            6 -> {
                "For the Jackpot!! ".also { doublePointsText.text = it }
                val num1 = (10..20).random()
                val num2 = (20..30).random()
                val answer = num1 * num2

                setProblemText("$num1 x $num2 = ")

                binding.GuessBtn.setOnClickListener {

                    val uAnsTxt = binding.userAnswerEditText.text.toString()
                    val userAnswerD = uAnsTxt.toDouble()
                    val userAnswer = userAnswerD.toInt()

                    if ((userAnswer == answer) && (currentPlayer == 1)) {
                        setPlayer1Points(getPlayer1Points() + getJackpotPoints())
                        setJackpotPoints(5)
                        "Correct!".also { doublePointsText.text = it }
                    } else if ((userAnswer == answer) && (currentPlayer == 2)) {
                        setPlayer2Points(getPlayer2Points() + getJackpotPoints())
                        setJackpotPoints(5)
                        "Correct!".also { doublePointsText.text = it }
                    } else if (userAnswer != answer) {
                        setJackpotPoints(getJackpotPoints() + 3)
                        "Incorrect!".also { doublePointsText.text = it }
                    }
                }
            } // Try for Jackpot
        } // Roll Dice
    } // Run Game
}


