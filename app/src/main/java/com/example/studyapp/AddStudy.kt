package com.example.studyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class AddStudy : AppCompatActivity() {
    private lateinit var rbk: RadioButton
    private lateinit var rba: RadioButton
    private lateinit var edtitle: EditText
    private lateinit var eddescrp: EditText
    private lateinit var eddetiles:EditText
    private lateinit var btnadd: Button
    private lateinit var btnback: Button
    private lateinit var dbhlpr: DBHlpr
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_study)

        rbk = findViewById(R.id.rbk)
        rba = findViewById(R.id.rba)
        edtitle = findViewById(R.id.edtitle)
        eddescrp = findViewById(R.id.eddescrp)
        eddetiles = findViewById(R.id.eddetiels)
        btnadd = findViewById(R.id.btnadd)
        btnback = findViewById(R.id.btnback)


        btnadd.setOnClickListener {
            addLessones()
        }
        btnback.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



    }
    fun addLessones(){
        dbhlpr = DBHlpr(applicationContext)

      if (rba.isChecked){
          dbhlpr.add("Android",edtitle.text.toString(), eddescrp.text.toString(),eddetiles.text.toString()
          )
          edtitle.text.clear()
          eddetiles.text.clear()
          eddescrp.text.clear()

      }
      if (rbk.isChecked)  {
          dbhlpr.add("Kotlin",edtitle.text.toString(), eddescrp.text.toString(),eddetiles.text.toString())
          rba.clearFocus()
          edtitle.text.clear()
          eddetiles.text.clear()
          eddescrp.text.clear()
      }
    }
}