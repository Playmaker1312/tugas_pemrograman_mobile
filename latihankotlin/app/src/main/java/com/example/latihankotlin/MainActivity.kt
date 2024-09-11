package com.example.latihankotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //menghubungkan elemen elemen di activity main kedalam xml
        val uUsername = findViewById<EditText>(R.id.eUsername)
        val uPassword = findViewById<EditText>(R.id.ePassword)
        val bLogin = findViewById<Button>(R.id.bLogin)

        //membuat button apa bila diclik pindah ke halaman welcome page
        bLogin.setOnClickListener{
            val Username = uUsername.text.toString()
            val Password = uPassword.text.toString()

            val intent = Intent(this, WelcomePage::class.java)
            intent.putExtra("username",Username)
            intent.putExtra("password",Password)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}