package com.example.impostorgame

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue


object Variables {
    var jugadores by mutableIntStateOf(4)
    var impostores by mutableIntStateOf(1)
}