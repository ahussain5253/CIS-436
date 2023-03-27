import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.R

class MainActivity : AppCompatActivity(), CalculatorButtonFragment.ButtonClickListener {
    private lateinit var calculatorDisplayFragment: CalculatorDisplayFragment
    private var currentNumber = ""
    private var currentOperation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculatorDisplayFragment = CalculatorDisplayFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.display_fragment_container, calculatorDisplayFragment)
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.button_fragment_container, CalculatorButtonFragment())
            .commit()
    }

    override fun onButtonClick(buttonText: String) {
        when {
            buttonText == "C" -> {
                currentNumber = ""
                currentOperation = ""
                calculatorDisplayFragment.updateDisplay(currentNumber)
            }
            buttonText == "." && currentNumber.contains(".") -> {
                // Do nothing
            }
            buttonText.matches(Regex("[0-9]|\\.")) -> {
                currentNumber += buttonText
                calculatorDisplayFragment.updateDisplay(currentNumber)
            }
            buttonText.matches(Regex("[+\\-*/]")) -> {
                if (currentOperation.isNotEmpty()) {
                    calculate()
                }
                currentOperation = buttonText
                currentNumber = ""
            }
            buttonText == "=" -> {
                calculate()
                currentOperation = ""
            }
       
