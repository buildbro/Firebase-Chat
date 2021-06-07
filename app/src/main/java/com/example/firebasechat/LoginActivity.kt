package com.example.firebasechat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.firebasechat.databinding.ActivityLoginBinding
import com.example.firebasechat.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
    }

    public fun loginUser(view: View) {
        var email: String = binding.loginEmailEditText.text.toString()
        var password: String = binding.loginPasswordEditText.text.toString()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, ChatActivity::class.java))
                } else {
                    Toast.makeText(this, "An error occurred", Toast.LENGTH_SHORT)
                }
            }
    }
}