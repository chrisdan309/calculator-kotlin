package com.example.calculatorcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun InputFields(
	input1: TextFieldValue,
	onInput1Change: (TextFieldValue) -> Unit,
	input2: TextFieldValue,
	onInput2Change: (TextFieldValue) -> Unit,
) {
	Column {
		TextField(value = input1,
			onValueChange = onInput1Change,
			keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
			label = { Text("Ingrese un numero") })
		Spacer(modifier = Modifier.height(40.dp))
		TextField(
			value = input2,
			onValueChange = onInput2Change,
			keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
			label = { Text("Ingrese un numero") })
	}
}