package com.example.studyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class KotlinActivity : AppCompatActivity() {

    private lateinit var rvKotlin: RecyclerView
    private lateinit var dbHlpr : DBHlpr

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        title = "Kotlin Review"
        rvKotlin = findViewById(R.id.rvKotlin)

        dbHlpr=DBHlpr(applicationContext)
        var lessons = dbHlpr.getData("Kotlin")
        dbHlpr= DBHlpr(applicationContext)

        rvKotlin.adapter = NewAdp(this, lessons)
        rvKotlin.layoutManager = LinearLayoutManager(this)

    }
}