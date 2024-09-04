package com.example.calculatorcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculatorcompose.ui.theme.CalculatorComposeTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			CalculatorComposeTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					CalculatorApp(
						modifier = Modifier.padding(innerPadding)
					)
				}
			}
		}
	}
}


@Preview
@Composable
fun PreviewTest() {
	Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
		CalculatorApp(
			modifier = Modifier.padding(innerPadding)
		)
	}
}