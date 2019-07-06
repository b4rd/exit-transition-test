package com.example.exittransitiontest

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.btn_start_detail).setOnClickListener {

            window.exitTransition = Slide(Gravity.LEFT).apply {
                addTarget(findViewById<View>(R.id.text))
            }

            val intent = Intent(this, DetailActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(this, findViewById(R.id.image), "droid_image")
            startActivity(intent, options.toBundle())
        }
    }
}
