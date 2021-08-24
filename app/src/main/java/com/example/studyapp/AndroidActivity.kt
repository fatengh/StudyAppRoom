package com.example.studyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AndroidActivity : AppCompatActivity() {

    private lateinit var rvAndroid: RecyclerView
    private lateinit var dbHlpr : DBHlpr
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android)

        title = "Android Review"
        rvAndroid = findViewById(R.id.rvAndroid)

        dbHlpr=DBHlpr(applicationContext)
        var lessons = dbHlpr.getData("Android")
        dbHlpr= DBHlpr(applicationContext)

        rvAndroid.adapter = NewAdp(this, lessons)
        rvAndroid.layoutManager = LinearLayoutManager(this)

    }
}