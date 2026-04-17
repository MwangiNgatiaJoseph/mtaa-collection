package com.zariel.chuisokogarden

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loopj.android.http.RequestParams
import java.util.Locale

class About : AppCompatActivity() {

    lateinit var tts: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val aboutinfo = findViewById<TextView>(R.id.textView)
        val text = findViewById<EditText>(R.id.inputText)
        val button = findViewById<Button>(R.id.speakButton)


//        START THE TEXT TO SPEECH ENGINE

        tts = TextToSpeech(this) {
//            check if the speech is successful
            if (it == TextToSpeech.SUCCESS) {
                tts.language = Locale.US
            }}

            button.setOnClickListener {
                val textt = text.text.toString()
                tts.speak(textt, TextToSpeech.QUEUE_FLUSH, null, null)

                val textts= text.text.toString()
                tts.speak(textt, TextToSpeech.QUEUE_FLUSH,null,null)



            }


        }

//        stop the tts from speaking when app is closed/destroy/killed

        override fun onDestroy() {
            tts.stop()
            tts.shutdown()
            super.onDestroy()
        }
    }

