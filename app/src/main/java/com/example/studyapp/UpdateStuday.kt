package com.example.studyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

class UpdateStuday : AppCompatActivity() {

    private lateinit var rba: RadioButton
    private lateinit var rbk: RadioButton

    private lateinit var edtitleD: EditText
    private lateinit var edtitleU: EditText
    private lateinit var eddes: EditText
    private lateinit var edDet: EditText
    private lateinit var edid: EditText


    private lateinit var btnDelete: Button
    private lateinit var btnUpdate: Button
    private lateinit var btnBack: Button


    private lateinit var dbhlpr: DBHlpr

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_studay)


        rbk = findViewById(R.id.rbKotlin)
        rba = findViewById(R.id.rbAndroid)
        edtitleD = findViewById(R.id.edtitleD)
        edid = findViewById(R.id.edid)
        edtitleU = findViewById(R.id.edtitleU)
        eddes = findViewById(R.id.eddes)
        edDet = findViewById(R.id.edDet)
        btnDelete = findViewById(R.id.btnDelete)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnBack = findViewById(R.id.btnBack)

        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnDelete.setOnClickListener {
            deleteLessones()
        }
        btnUpdate.setOnClickListener {
            UpdateLessones()
        }


    }

    fun deleteLessones() {
        dbhlpr = DBHlpr(applicationContext)

        if (rba.isChecked) {
            dbhlpr.delete("Android", edtitleD.text.toString().toInt())
            edtitleD.text.clear()

        }
        else if (rbk.isChecked) {
            dbhlpr.delete("Kotlin", edtitleD.text.toString().toInt())
            edtitleD.text.clear()

        }else{
            Toast.makeText(applicationContext,"choose kotlin or android",Toast.LENGTH_LONG).show()
        }
    }

    fun UpdateLessones() {
        dbhlpr = DBHlpr(applicationContext)
        if (rba.isChecked) {
            dbhlpr.update(
                "Android",
                edid.text.toString().toInt(),
                edtitleU.text.toString(),
                eddes.text.toString(),
                edDet.text.toString()
            )
            edid.text.clear()

            edtitleU.text.clear()
            eddes.text.clear()
            edDet.text.clear()

        }
        else if (rbk.isChecked) {
            dbhlpr.update(
                "Kotlin",
                edid.text.toString().toInt(),
                edtitleU.text.toString(),
                eddes.text.toString(),
                edDet.text.toString()
            )
            edid.text.clear()
            edtitleU.text.clear()
            eddes.text.clear()
            edDet.text.clear()
        }
        else{
            Toast.makeText(applicationContext,"choose kotlin or android",Toast.LENGTH_LONG).show()
        }
    }
}