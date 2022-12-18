package com.example.studenthardlife

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.studenthardlife.databinding.ActivityMainBinding
import com.example.studenthardlife.databinding.FragmentListBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { FragmentListBinding.inflate(layoutInflater) }
    private val dbHandler by lazy { DBHandler(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}