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

class AddActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorScreen()
        }
    }
}

@Composable
fun StatelessCalculator(
    number1: String,
    number2: String,
    result: String,
    onNumber1Change: (String) -> Unit,
    onNumber2Change: (String) -> Unit,
    onCalculate: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        // 숫자 1 입력 필드
        TextField(
            value = number1,
            onValueChange = onNumber1Change,
            label = { Text("숫자 1 입력") }
        )

        // 숫자 2 입력 필드
        TextField(
            value = number2,
            onValueChange = onNumber2Change,
            label = { Text("숫자 2 입력") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 더하기 버튼
        Button(onClick = onCalculate) {
            Text("더하기")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 결과 출력
        Text(text = "결과: $result")
    }
}

@Composable
fun CalculatorScreen() {
    // 상태 호이스팅: 두 숫자와 결과 상태 관리
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("0") }

    // 계산 버튼 클릭 시 더하기 수행
    fun calculate() {
        val num1 = number1.toIntOrNull() ?: 0
        val num2 = number2.toIntOrNull() ?: 0
        result = (num1 + num2).toString()
    }

    // StatelessCalculator에 상태와 콜백 전달
    StatelessCalculator(
        number1 = number1,
        number2 = number2,
        result = result,
        onNumber1Change = { number1 = it },
        onNumber2Change = { number2 = it },
        onCalculate = { calculate() }
    )
}

@Preview
@Composable
fun CalculatorPreview() {
    CalculatorScreen()
}
