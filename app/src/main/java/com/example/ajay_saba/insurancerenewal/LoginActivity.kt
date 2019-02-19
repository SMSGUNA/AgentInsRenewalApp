package com.example.ajay_saba.insurancerenewal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)




        buLogin.setOnClickListener{
            val email = etEmail_Login.text.toString()
            val password = etPassword_Login.text.toString()

            if(email.isEmpty() || password.isEmpty())  {
                Toast.makeText(this,"Enter Email or password",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Log.d("RegisterActivity","Email : $email")
            Log.d("RegisterActivity","Password: $password")

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener {
                if (!it.isSuccessful) return@addOnCompleteListener

                Toast.makeText(this,"LOGGED IN SUCCESSFULLY",Toast.LENGTH_SHORT).show()
                val intent = Intent(this,LatestMessagesActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)

            }
            .addOnFailureListener {
                Toast.makeText(this,"INCORRECT EMAIL/PASSWORD",Toast.LENGTH_SHORT).show()
            }
        }

       val ref = FirebaseDatabase.getInstance().reference


    }

}

