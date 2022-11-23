package com.dodi.livedatasample

import android.os.SystemClock
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Timer
import java.util.TimerTask

class MainViewModel : ViewModel() {

    private val initialTime = SystemClock.elapsedRealtime()
    private val elapsedTime = MutableLiveData<Long?>()

    init {
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask(){
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - initialTime) / 1000
                elapsedTime.postValue(newValue)
            }

        }, ONE_SECOND.toLong(), ONE_SECOND.toLong())
    }

    companion object{
        private const val ONE_SECOND = 1000
    }
}