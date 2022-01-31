package com.t4zb.cv_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.t4zb.cv_project.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mbindibg: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbindibg = ActivityMainBinding.inflate(layoutInflater)
        val  view = mbindibg.root
        setContentView(view)

        supportActionBar?.hide()

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);




    }
}