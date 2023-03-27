import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculator.R

class CalculatorButtonFragment : Fragment() {
    private lateinit var buttonClickListener: ButtonClickListener

    interface ButtonClickListener {
        fun onButtonClick(buttonText: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            buttonClickListener = context as ButtonClickListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement ButtonClickListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calculator_button, container, false)
        val buttons = listOf(
            view.findViewById(R.id.button_0),
            view.findViewById(R.id.button_1),
            view.findViewById(R.id.button_2),
            view.findViewById(R.id.button_3),
            view.findViewById(R.id.button_4),
            view.findViewById(R.id.button_5),
            view.findViewById(R.id.button_6),
            view.findViewById(R.id.button_7),
            view.findViewById(R.id.button_8),
            view.findViewById(R.id.button_9),
            view.findViewById(R.id.button_decimal),
            view.findViewById(R.id.button_add),
            view.findViewById(R.id.button_subtract),
            view.findViewById(R.id.button_multiply),
            view.findViewById(R.id.button_divide),
            view.findViewById(R.id.button_clear),
            view.findViewById(R.id.button_equals)
        )

        for (button in buttons) {
            button.setOnClickListener {
                buttonClickListener.onButtonClick(button.text.toString())
            }
        }

        return view
    }
}
