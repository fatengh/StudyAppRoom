package com.example.studyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnKotlin: Button
    private lateinit var btnAndroid: Button
    private lateinit var btnAdd: Button
    private lateinit var btnUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnKotlin = findViewById(R.id.btnKotlin)
        btnAndroid = findViewById(R.id.btnAndroid)
        btnAdd = findViewById(R.id.btnAdd)
        btnUpdate = findViewById(R.id.btnUpdate)

        btnAndroid.setOnClickListener {
            val intent = Intent(this, AndroidActivity::class.java)
            startActivity(intent)
        }
        btnKotlin.setOnClickListener {
            val intent = Intent(this, KotlinActivity::class.java)
            startActivity(intent)
        }
        btnAdd.setOnClickListener {
            val intent = Intent(this,AddStudy::class.java)
            startActivity(intent)
        }
        btnUpdate.setOnClickListener {
            val intent = Intent(this, UpdateStuday::class.java)
            startActivity(intent)
        }
    }
}