package com.example.compose

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CalculatorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorApp()
        }
    }
}

@Composable
fun CalculatorApp() {
    var number1 by remember { mutableStateOf(TextFieldValue("")) }
    var number2 by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "계산기", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = number1,
            onValueChange = { number1 = it },
            modifier = Modifier
                .background(Color.LightGray)
                .padding(8.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = number2,
            onValueChange = { number2 = it },
            modifier = Modifier
                .background(Color.LightGray)
                .padding(8.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                result = try {
                    (number1.text.toInt() + number2.text.toInt()).toString()
                } catch (e: Exception) {
                    "잘못된 입력"
                }
            }) {
                Text(text = "+")
            }

            Button(onClick = {
                result = try {
                    (number1.text.toInt() - number2.text.toInt()).toString()
                } catch (e: Exception) {
                    "잘못된 입력"
                }
            }) {
                Text(text = "-")
            }

            Button(onClick = {
                result = try {
                    (number1.text.toInt() * number2.text.toInt()).toString()
                } catch (e: Exception) {
                    "잘못된 입력"
                }
            }) {
                Text(text = "×")
            }

            Button(onClick = {
                result = try {
                    if (number2.text.toInt() != 0) {
                        (number1.text.toInt() / number2.text.toInt()).toString()
                    } else {
                        "0으로 나눌 수 없음"
                    }
                } catch (e: Exception) {
                    "잘못된 입력"
                }
            }) {
                Text(text = "÷")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "결과: $result", fontSize = 24.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorAppPreview() {
    CalculatorApp()
}