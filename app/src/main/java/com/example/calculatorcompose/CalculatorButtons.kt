package com.example.calculatorcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CalculatorButtons(
	input1: TextFieldValue,
	input2: TextFieldValue,
	onResultChange: (String) -> Unit
) {
	Column(
		modifier = Modifier
			.width(220.dp)
			.fillMaxWidth(),
		verticalArrangement = Arrangement.spacedBy(16.dp)
	) {
		Row(
			horizontalArrangement = Arrangement.spacedBy(16.dp)
		) {
			ButtonCalculator(
				input1,
				input2,
				{ num1, num2 -> num1 + num2 },
				"+",
				onResultChange,
				Modifier.weight(1f)
			)
			ButtonCalculator(
				input1,
				input2,
				{ num1, num2 -> num1 - num2 },
				"-",
				onResultChange,
				Modifier.weight(1f)
			)
		}
		Row(
			horizontalArrangement = Arrangement.spacedBy(16.dp)
		) {
			ButtonCalculator(
				input1,
				input2,
				{ num1, num2 -> num1 * num2 },
				"x",
				onResultChange,
				Modifier.weight(1f)
			)
			ButtonCalculator(
				input1,
				input2,
				{ num1, num2 -> if (num2 != 0.0) num1 / num2 else Double.NaN },
				"÷",
				onResultChange,
				Modifier.weight(1f)
			)
		}
	}
}

@Composable
fun ButtonCalculator(
	input1: TextFieldValue,
	input2: TextFieldValue,
	operation: (Double, Double) -> Double,
	symbol: String,
	onResultChange: (String) -> Unit,
	modifier: Modifier
) {
	Button(
		onClick = {
			val number1 = input1.text.toDoubleOrNull() ?: 0.0
			val number2 = input2.text.toDoubleOrNull() ?: 0.0
			val resultant = operation(number1, number2)
			val result = "Resultado: %.4f".format(resultant)
			onResultChange(result)
		},
		modifier = modifier
			.fillMaxWidth()
			.aspectRatio(1f)
			.size(20.dp)
	) {
		Text(symbol, fontSize = 54.sp)
	}
}