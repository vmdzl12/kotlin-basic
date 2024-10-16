package com.example.xml

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.xml.databinding.ActivityCalBinding


class CountActivity : AppCompatActivity() {

    private var count = 0
    private lateinit var binding: ActivityCalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding()
    }

    private fun viewIntent() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.naver.com")
        startActivity(intent)
    }

    private fun callIntent() {
        setContentView(R.layout.activity_cal)

        val callButton = findViewById<Button>(R.id.increaseButton)

        callButton.setOnClickListener {
            // 전화번호로 전화를 거는 Intent 생성
            val phoneNumber = "tel:01012345678"
            val callIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse(phoneNumber)
            }

            startActivity(callIntent)
        }
    }

    private fun findView() {
        setContentView(R.layout.activity_cal)

        val countTextView = findViewById<TextView>(R.id.countTextView)
        countTextView.text = count.toString()
        val increaseButton = findViewById<Button>(R.id.increaseButton)
        val resetButton = findViewById<Button>(R.id.resetButton)

        // 증가 버튼 클릭 시 카운트 증가
        increaseButton.setOnClickListener {
            count++
            countTextView.text = count.toString()
        }

        // 초기화 버튼 클릭 시 카운트 초기화
        resetButton.setOnClickListener {
            count = 0
            countTextView.text = count.toString()
        }
    }

    private fun binding() {
        // View Binding 초기화
        binding = ActivityCalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            // 카운터 증가 버튼
            increaseButton.setOnClickListener {
                count++
                countTextView.text = count.toString()
            }

            // 카운터 초기화 버튼
            resetButton.setOnClickListener {
                count = 0
                countTextView.text = count.toString()
            }
        }
    }
}
