package com.dodi.livedatasample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dodi.livedatasample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        subscribeData()
    }

    private fun subscribeData(){
        val observer = Observer<Long?>{
            val newText = this@MainActivity.resources.getString(R.string.seconds,it)
            activityMainBinding.timerTextview.text = newText
        }

        mainViewModel.getElapsedTime().observe(this,observer)
    }
}