package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class DarkActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DarkModeToggleApp()
        }
    }
}

@Composable
fun DarkModeToggleApp() {
    // 다크 모드 상태를 관리하는 변수
    var isDarkMode by remember { mutableStateOf(false) }

    // 테마 색상 정의 (Material 3)
    val colors = if (isDarkMode) {
        darkColorScheme(
            primary = Color.Black,
            secondary = Color.Gray,
            background = Color.DarkGray,
            onPrimary = Color.White
        )
    } else {
        lightColorScheme(
            primary = Color.White,
            secondary = Color.Blue,
            background = Color.LightGray,
            onPrimary = Color.Black
        )
    }

    MaterialTheme(colorScheme = colors) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // 다크 모드 상태에 따라 다른 텍스트를 표시하는 버튼
                Button(
                    onClick = { isDarkMode = !isDarkMode }, // 다크 모드 상태 토글
                ) {
                    Text(if (isDarkMode) "Disable Dark Mode" else "Enable Dark Mode")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDarkModeToggleApp() {
    DarkModeToggleApp()
}