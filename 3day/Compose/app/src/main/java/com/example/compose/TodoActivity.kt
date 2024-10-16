package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class TodoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoApp()
        }
    }
}

@Composable
fun TodoApp() {
    var todoText by remember { mutableStateOf("") }
    var todoList by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            // 할 일 입력 필드
            TextField(
                value = todoText,
                onValueChange = { todoText = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text(stringResource(R.string.hint)) }
            )

            Spacer(modifier = Modifier.width(8.dp))

            // 추가 버튼
            Button(
                onClick = {
                    if (todoText.isNotEmpty()) {
                        todoList = todoList + todoText
                        todoText = ""
                    }
                },
                enabled = todoText.isNotEmpty()
            ) {
                Text("추가")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 할 일 목록 표시
        LazyColumn {
            items(todoList.size) { index ->
                // Text(text = todoList[index], modifier = Modifier.padding(8.dp))
                Text(
                    text = todoList[index],
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable(
                            onClick = {
                                todoList = todoList.toMutableList().also { it.removeAt(index) }
                            }
                        )
                )
            }
        }
    }
}
