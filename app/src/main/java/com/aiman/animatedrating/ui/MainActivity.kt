package com.aiman.animatedrating.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.aiman.animatedrating.R
import com.aiman.animatedrating.databinding.ActivityMainBinding
import com.aiman.animatedrating.databinding.ActivityMainBindingImpl

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}