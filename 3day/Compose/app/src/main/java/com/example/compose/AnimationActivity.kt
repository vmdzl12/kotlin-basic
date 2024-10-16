package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class AnimationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedButtonApp()
        }
    }
}

@Composable
fun AnimatedButtonApp() {
    var expanded by remember { mutableStateOf(false) }

    // 크기와 색상의 애니메이션 상태 정의
    val size by animateDpAsState(targetValue = if (expanded) 200.dp else 100.dp)
    val color by animateColorAsState(targetValue = if (expanded) Color.Green else Color.Blue)

    // 중앙에 애니메이션 버튼 배치
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { expanded = !expanded }, // 클릭 시 상태 변경
            colors = ButtonDefaults.buttonColors(
                containerColor = color,
                contentColor = if (expanded) Color.Black else Color.White
            ),
            modifier = Modifier.size(size) // 크기 애니메이션 적용
        ) {
            Text(text = if (expanded) "축소" else "확대")
        }
    }
}
