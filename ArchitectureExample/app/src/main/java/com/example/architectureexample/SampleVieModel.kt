package com.example.architectureexample

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class SampleVieModel: ViewModel() {
    var backGroudColour by mutableStateOf(Color.White)
        private set

    fun changeBackGroundColour(){
        backGroudColour = Color.Red
    }
}