package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.btn_ingresar);

        boton.setOnClickListener {
                val intent = Intent(this@MainActivity, pantalla_revistas::class.java)
                startActivity(intent);
        }



    }
}