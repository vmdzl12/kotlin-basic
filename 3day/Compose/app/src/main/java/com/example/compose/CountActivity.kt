package com.example.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CountActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCounterApp()
        }
    }
}

private var count = 0

@Composable
fun MyCounterApp() {
    var count by remember { mutableStateOf(0) }

    // UI 구성
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 현재 카운트 값 표시
        val tt = Text(text = "$count", fontSize = 48.sp)


        Spacer(modifier = Modifier.height(16.dp))

        // 카운트 증가 버튼
        Button(onClick = {
            count++
        }) {
            Text(text = "증가")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 카운트 초기화 버튼
        Button(onClick = { count = 0 }) {
            Text(text = "초기화")
        }
    }
}

@Composable
fun CounterExample() {
    // var count by remember { mutableStateOf(0) }

    Column {
        Text("현재 카운트: $count")
        Button(onClick = { count++ }) {
            Text("증가")
        }
    }
}
