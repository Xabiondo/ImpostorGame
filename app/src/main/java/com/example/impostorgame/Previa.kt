package com.example.impostorgame

import android.R
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.util.ArrayList
import kotlin.random.Random


@Composable
fun PreviaPage(navController: NavController){

    val totalImpostores = remember { Variables.impostores }
    val totalJugadores = remember { Variables.jugadores + Variables.impostores }
    val listaJugadores = remember { mutableStateListOf<Jugador>() }
    var nombreActual = remember { mutableStateOf("") }
    val indice = listaJugadores.size +1

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally ,

    ) {
        Text("has elegido " + Variables.jugadores + " Jugadores" ,
            color = Color.White)

        Text("has elegido " + Variables.impostores + " impostores " ,
            color =  Color.White)

        Variables.paquetesUsuario.forEach {paquete ->
            Text(text = "has elegido la tematica " + paquete.tema
            , color = Color.White)
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


        }else{
            Text("todos listos para empezar" , color = Color.White)
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    asignarRoles(jugadores = listaJugadores , numImpostores = totalImpostores , navController)
                    navController.navigate("juego")
                }
            ) {
                Text("vamos a empezarrrrrrrrr")
            }
        }


    }
}

fun asignarRoles ( jugadores: MutableList<Jugador> , numImpostores: Int , navController: NavController){
    for (jugador in jugadores) {
        jugador.rol = Rol.CIVIL
    }

    val valoresBarajeados = (jugadores.indices).shuffled()

    for (i in  0..numImpostores -1){
        val indiceImpostor = valoresBarajeados[i]
        jugadores[indiceImpostor].rol = Rol.IMPOSTOR;
    }
    Variables.listaJugadores = jugadores ;


}