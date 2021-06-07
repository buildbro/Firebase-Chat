package com.example.firebasechat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.firebasechat.databinding.ActivityMainBinding
import com.example.firebasechat.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        binding = ActivityRegistrationBinding.inflate(layoutInflater)

        auth = FirebaseAuth.getInstance()
    }

    public fun registerUser(view: View) {

        var email: String = binding.emailEditText.text.toString()
        var password: String = binding.passwordEditText.text.toString()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, ChatActivity::class.java))
                } else {
                    Toast.makeText(this, "An error occurred", Toast.LENGTH_SHORT)
                }
            }
    }
}