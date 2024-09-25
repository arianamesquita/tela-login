
package com.example.myapplication4

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication4.model.Usuario

class BemVindoActivity: AppCompatActivity() {
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bem_vindo_activity)

        val usuario: Usuario? = intent.getParcelableExtra("object", Usuario::class.java)

        val tText: TextView = findViewById(R.id.textView)
        tText.setText("${usuario?.nome}, seja bem vindo! \nSeus dados: \n nome: ${usuario?.login}  \n login: ${usuario?.senha}")

        val button: Button = findViewById(R.id.button2)
        button.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}