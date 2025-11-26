package com.example.impostorgame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.util.ArrayList



@Composable
fun PreviaPage(navController: NavController){
    val totalCiviles = remember { 0 }
    val totalImpostores = remember { 0 }
    val totalJugadores = remember { Variables.jugadores + Variables.impostores }
    val listaJugadores = remember { mutableStateListOf<Jugador>() }
    var nombreActual = remember { mutableStateOf("") }
    val indice = listaJugadores.size +1
    var partida = Partida(
        jugadores = ArrayList<Jugador>() ,
        paquetes = Variables.paquetesUsuario,
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(horizontal = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally ,

    ) {
        Text("has elegido " + Variables.jugadores)

        Text("has elegido " + Variables.impostores)

        Variables.paquetesUsuario.forEach {paquete ->
            Text(text = "has elegido la tematica " + paquete.tema)
        }

        if (listaJugadores.size < totalJugadores){
            Text(text = "introduce el número del jugador  $indice" ,
                color = Color.White)

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = nombreActual.value ,
                onValueChange = {nombreActual.value = it} ,
                label = {Text(text = "pon un nombre")} ,
                modifier = Modifier.fillMaxWidth() ,
                singleLine = true
            )

            Button(
                onClick = {
                    if (nombreActual.value.isNotBlank()){
                        var nuevoJugador = Jugador(nombre = nombreActual.value)
                        listaJugadores.add(nuevoJugador)
                        nombreActual.value = "";


                    }
                }
            ) {
                Text(text = "siguiente jugador")
            }


        }else
            Text(text = "ya estamos todos")




    }
}