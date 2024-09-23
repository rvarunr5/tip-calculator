package com.example.tipCalculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipCalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.button15.setOnClickListener{
			calculateTip(0.15)
		}
		binding.button18.setOnClickListener {
			calculateTip(0.18)
		}
		binding.button20.setOnClickListener {
			calculateTip(0.20)
		}
	}

	private fun calculateTip(tipPercentage: Double){
		val billAmountText = binding.editTextBillAmount.text.toString()
		if(billAmountText.isNotEmpty()){
			val billAmount = billAmountText.toDouble()
			val tip = billAmount * tipPercentage
			val tipFormatted = String.format("%.2f", tip)
			binding.textViewTipAmount.text = "Tip: $$tipFormatted, Total Bill: $$billAmount"
		} else {
			Toast.makeText(this, "Please enter a valid bill amount", Toast.LENGTH_SHORT).show()
		}
	}
}