package com.example.latihankotlin
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class WelcomePage : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.welcome_page)

        //mengambil data daru intent
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

        // menemukan textview dengan id hello di file xml welcome_page
        val textView = findViewById<TextView>(R.id.hello)

        textView.text = "hello world\nUsername : $username \nPassword : $password"




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.welcome)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}