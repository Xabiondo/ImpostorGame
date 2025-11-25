package com.example.impostorgame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun PreviaPage(navController: NavController){
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






    }
}