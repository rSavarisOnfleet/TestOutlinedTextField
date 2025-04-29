package com.example.myapplication

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewmodel @Inject constructor(): ViewModel() {

    init {
        println("INIT VIEWMODEL")
    }

    val componentState1 = TextFieldState()
    val componentState2 = TextFieldState()
    val componentState3 = TextFieldState()

}