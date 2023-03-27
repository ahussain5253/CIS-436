import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.calculator.R

class CalculatorDisplayFragment : Fragment() {
    private lateinit var displayText: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calculator_display, container, false)
        displayText = view.findViewById(R.id.display_text)
        return view
    }

    fun updateDisplay(text: String) {
        displayText.text = text
    }
}
