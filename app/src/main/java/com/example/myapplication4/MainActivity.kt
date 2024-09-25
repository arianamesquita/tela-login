package com.example.myapplication4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication4.model.Usuario

class MainActivity : AppCompatActivity() {
    val usuariosMocados = listOf(
        Usuario("Pedro", "phfj0001", "phfj1000"),
        Usuario("Ariana", "arianamesquita", "amg8507"),
        Usuario("Augusto","amgb0001", "amgb1234"),
        Usuario("Janine", "janineagro", "jmg8407")
    )

    fun validarLogin(login: String, senha: String): Usuario? {
        for (usuario in usuariosMocados){
            if(usuario.login.equals(login) && usuario.senha.equals(senha)){
                return usuario
            }
        }
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener(){
            onSendMessage(it)
        }

    }

    fun onSendMessage(view: View) {
        val tLogin: EditText = findViewById(R.id.editTextName)
        val tSenha: EditText = findViewById(R.id.editTextPassword)

        tLogin.setOnFocusChangeListener{view, hasFocus ->
            if(hasFocus){
                tLogin.setText("")
            }
        }
        tSenha.setOnFocusChangeListener{view, hasFocus ->
            if(hasFocus){
                tSenha.setText("")
            }
        }

        val usuario = validarLogin(tLogin.text.toString(), tSenha.text.toString())

        if (usuario != null) {
            val intent = Intent(this, BemVindoActivity::class.java)
            intent.putExtra("object", usuario)
            startActivity(intent)
        } else {
            tLogin.setText("")
            tSenha.setText("")
            alert("Login e senha incorretos!")
        }
    }

    fun alert(s: String){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}