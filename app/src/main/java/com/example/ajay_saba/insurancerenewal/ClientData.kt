package com.example.ajay_saba.insurancerenewal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_client_data.*

class ClientData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_data)

        val username = intent.getStringExtra(NewMessageActivity.USER_KEY)
        supportActionBar?.title="USER DETAILS"
        tvClientName_CD.setText(username)

    }
}
