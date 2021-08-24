package com.example.studyapp

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface

class CustomAlertDialog(activity: Activity, title: String) {
    init {

        val dialogBuilder = AlertDialog.Builder(activity)
        dialogBuilder.setMessage(title)
            .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })
        val alert = dialogBuilder.create()
        alert.show()
    }
}