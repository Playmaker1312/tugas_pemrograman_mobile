package com.example.latihankotlin

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class listviewactivity : AppCompatActivity() {

    private lateinit var lv_data : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.listview)

    //mengambil list view yang ada di xml listview dengna id lv_data
    lv_data = findViewById(R.id.lv_data)


    //buat array
        val namahewan = listOf(
            "gajah",
            "kuda",
            "beruang",
            "panda",
            "ular",
            "kucing",
            "sapi",
            "kerbau",
            "ikan",
        )

        //memasukan data array ke adapter
        //android layout --> layout bawaan untuk adapter
        lv_data.adapter =ArrayAdapter(this, android.R.layout.simple_list_item_1, namahewan)

        //untuk bisa di klik dari list
        lv_data.setOnItemClickListener{
                parent, view, position, id ->
            Toast.makeText(this, "anda memilih : ${namahewan[position]}",
                Toast.LENGTH_SHORT).show()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.welcome)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}