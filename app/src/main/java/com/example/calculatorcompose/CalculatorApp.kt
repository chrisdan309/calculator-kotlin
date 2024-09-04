package com.example.calculatorcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorApp(modifier: Modifier) {
	var input1 by remember { mutableStateOf(TextFieldValue("")) }
	var input2 by remember { mutableStateOf(TextFieldValue("")) }
	var result by remember { mutableStateOf("") }
	val context = LocalContext.current
	Column(
		modifier = modifier
			.fillMaxSize()
			.padding(16.dp)
	) {
		Text(
			text = "Calculadora",
			fontSize = 24.sp,
			modifier = Modifier.align(Alignment.CenterHorizontally)
				.padding(top = 32.dp)
		)

		Spacer(modifier = Modifier.height(32.dp))

		Column(
			modifier = modifier
				.fillMaxSize(),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			InputFields(input1, { input1 = it }, input2, { input2 = it })
			Spacer(modifier = Modifier.height(80.dp))
			CalculatorButtons(input1, input2) { result = it }
			Spacer(modifier = Modifier.height(80.dp))
			Text(text = result, fontSize = 24.sp)
		}

	}

}