package com.example.di

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.di.ui.theme.DITheme

class MainActivity : ComponentActivity() {

    private lateinit var userService: UserService  // UserService 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        // 수동으로 LocalRepository 생성 후 UserService에 전달
        val repository = LocalRepository()
        userService = UserService(repository)

        // UserService의 메서드 실행
        userService.printData()  // 콘솔에 "Data from Local Repository" 출력
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

interface Repository {
    fun getData(): String
}

class LocalRepository : Repository {
    override fun getData(): String {
        return "Data from Local Repository"
    }
}

class UserService(private val repository: Repository) {
    fun printData() {
        Log.d("DI_TAG", repository.getData())
    }
}
