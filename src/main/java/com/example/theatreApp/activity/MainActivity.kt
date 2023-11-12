package com.example.theatreApp.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.theatreApp.R
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        val button = findViewById<Button>(R.id.button)
        val editTextEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextPassword = findViewById<EditText>(R.id.editTextTextPassword)

        button.setOnClickListener {
            if (editTextEmail.text.isNullOrBlank() || editTextPassword.text.isNullOrBlank()) {
                Toast.makeText(applicationContext, "Empty fields", Toast.LENGTH_LONG).show()
            } else {

                auth.signInWithEmailAndPassword(
                    editTextEmail.text.toString(),
                    editTextPassword.text.toString()
                )
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {

                            Log.d("m", "signInWithEmail:success")
                            val user = auth.currentUser
                            startActivity(
                                Intent(this, NavigationActivity::class.java)
                            )
                            finish()
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Z", "signInWithEmail:failure", task.exception)
                            Toast.makeText(
                                applicationContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }

    }
}