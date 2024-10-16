package com.example.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CountViewModelActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("TAG", "onCreate")
        setContent {
            CounterScreen(CounterViewModel())
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("TAG", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("TAG", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("TAG", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "onDestroy")
    }
}

class CounterViewModel : ViewModel() {
    private val _count = mutableStateOf(0)
    val count: State<Int> = _count

    fun increment() {
        _count.value++
    }
}

@Composable
fun CounterScreen(viewModel: CounterViewModel) {
    val count by viewModel.count

    LaunchedEffect(Unit) {
        Log.e("TAG", "LaunchedEffect")
    }

    DisposableEffect(Unit) {
        onDispose {
            Log.e("TAG", "dispose")
        }
    }

    Column {
        Text("현재 카운트: $count")
        Button(onClick = { viewModel.increment() }) {
            Text("증가")
        }
    }
}
