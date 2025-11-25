package com.example.impostorgame

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue



var paquetesSeleccionados: ArrayList<Paquete> = ArrayList<Paquete>();
object Variables {
    var jugadores by mutableIntStateOf(4)
    var impostores by mutableIntStateOf(1)

    var paquetesUsuario : MutableList<Paquete> = (paquetesSeleccionados);
}