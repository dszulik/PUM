package com.example.physicalquiz

import android.content.Intent
import android.content.Intent.CATEGORY_BROWSABLE
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

const val EXTRA_MESSAGE = "com.example.physicalquiz.MESSAGE"
const val EXTRA_MESSAGE_REPLY = "com.example.physicalquiz.MESSAGE_REPLY"
const val EXTRA_URL = "com.example.physicalquiz.URL"


class Cheat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        val questionTextInCheatingActivity: TextView by lazy { findViewById(R.id.cheatingTextView)}

        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val url = intent.getStringExtra(EXTRA_URL)

        questionTextInCheatingActivity.text = message

        questionTextInCheatingActivity.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply{
                addCategory(CATEGORY_BROWSABLE)
            }

            if (intent.resolveActivity(packageManager) != null)
                startActivity(intent)

        }
    }
}
