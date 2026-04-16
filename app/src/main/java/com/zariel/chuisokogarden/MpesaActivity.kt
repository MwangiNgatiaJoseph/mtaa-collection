package com.zariel.chuisokogarden

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.loopj.android.http.RequestParams

class MpesaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mpesa)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val productname=findViewById<TextView>(R.id.product_name)
        val productcost=findViewById<TextView>(R.id.product_cost)
        val productphoto=findViewById<ImageView>(R.id.product_photo)
        val phonenumber=findViewById<TextView>(R.id.phone)
        val productdescription=findViewById<TextView>(R.id.product_description)
        val purchase=findViewById<Button>(R.id.purchase)


        val name= intent.getStringExtra("product_name")
        val cost= intent.getIntExtra("product_cost",0)
        val photo= intent.getStringExtra("product_photo")
        val description= intent.getStringExtra("product_description")



//        Update TextView with Values Passed Via Intent

        productname.text= name
        productcost. text= "Ksh $cost"

        Glide.with(this)
            .load(photo)
            .into(productphoto)

        purchase.setOnClickListener {
            val api="https://shinejoe.alwaysdata.net/api/mpesa_payment"

            //        create data using Request params
            val data = RequestParams()
            data.put("amount", productcost)   //Passed via Intennt
            data.put("phone",phonenumber.text.toString())


            val helper = ApiHelper(applicationContext)
//        post data to api endpiont
            helper.post(api, data)

        }






    }
}