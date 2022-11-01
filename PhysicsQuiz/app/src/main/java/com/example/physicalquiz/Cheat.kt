package com.example.physicalquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

const val EXTRA_MESSAGE = "com.example.physicalquiz.MESSAGE"
const val EXTRA_ID = "com.example.physicalquiz.ID"
const val EXTRA_MESSAGE_REPLY = "com.example.physicalquiz.MESSAGE_REPLY"
const val EXTRA_ID_REPLY = "com.example.physicalquiz.ID_REPLY"
const val EXTRA_URL = "com.example.physicalquiz.URL"


class Cheat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        val questionTextInCheatingActivity: TextView by lazy { findViewById(R.id.cheatingTextView)}

        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val id = intent.getStringExtra(EXTRA_ID)
        val url = intent.getStringExtra(EXTRA_URL)

        questionTextInCheatingActivity.text = message

        fun searchInInternet () {
            questionTextInCheatingActivity.setOnClickListener {
                Toast.makeText(
                    this, "kliknieto w pytanie",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        fun returnMessage(view: View) {
            setResult(
                RESULT_OK,
                Intent().apply {
                    putExtra(EXTRA_MESSAGE_REPLY, questionTextInCheatingActivity.text)
                    putExtra( EXTRA_ID_REPLY, id)
                })
            finish()
        }

        Toast.makeText(
            this, "przekazano id = $id",
            Toast.LENGTH_SHORT
        ).show()

    }
}
