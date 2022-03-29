package br.com.exemplo.unittools

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Carregar componentes
        val btnSom = findViewById<ImageButton>(R.id.btnSom)

        btnSom.setOnClickListener{
            val intent = Intent(this, ConversorSom::class.java)
            startActivity(intent)
        }
    }
}