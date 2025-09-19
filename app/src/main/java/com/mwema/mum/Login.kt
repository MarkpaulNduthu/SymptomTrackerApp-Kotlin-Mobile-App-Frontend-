package com.mwema.mum

import androidx.activity.enableEdgeToEdge
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mwema.mum.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.loginButton.setOnClickListener { signup() }
        binding.signupFirebase.setOnClickListener {
            Toast.makeText(this, "Signup with Firebase", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, Signup::class.java))
        }
    }

    private fun signup() {
        val email: String = binding.loginEmail.text.toString()
        val password: String = binding.loginPassword.text.toString()
        if(email=="paulmarkmwema@gmail.com" && password =="12345678"){
            startActivity(Intent(this,Home::class.java))
        }else{
            Toast.makeText(this,"Incorrect Login details",Toast.LENGTH_SHORT).show()
        }
    }
}