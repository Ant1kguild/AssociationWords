package com.example.associationwords.ui

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.associationwords.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashActivity : AppCompatActivity() {
    var textAssociation : ImageView? = null
    var textWords : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        textAssociation = findViewById(R.id.iv_association)

        val intent = Intent(this, StartActivity::class.java)

        CoroutineScope(Dispatchers.Main).launch {
            delay(4000)

            startActivity(intent)
            finish()

        }



    }
}
