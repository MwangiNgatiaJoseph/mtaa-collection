package com.zariel.chuisokogarden

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loopj.android.http.RequestParams

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val signIn=findViewById<TextView>(R.id.signin_link)

        signIn.setOnClickListener {

            val signInIntent = Intent(applicationContext, SignIn::class.java)
            startActivity(signInIntent)
        }
        //        find the edittext button by id
        val email=findViewById<EditText>(R.id.email)
        val password=findViewById<EditText>(R.id.password)
        val signupbutton=findViewById<Button>(R.id.signupbutton)
        val username=findViewById<EditText>(R.id.name)
        val phone=findViewById<EditText>(R.id.number)

        signupbutton.setOnClickListener {
            val api="http//shinejoe.alwaysdata.net/api/signup"

//            request params is the container used to collect the user detail it`s like form data in js

            val data = RequestParams()

            data.put("email",email.text.toString().trim())
            data.put("password",password.text.toString().trim())
            data.put("username",username.text.toString().trim())
            data.put("phone",phone.text.toString().trim())

//            Api helper-it delivery our data to the api

            val helper= ApiHelper(applicationContext)
            helper.post_login(api,data)

        }

    }
}