package com.example.impostorgame

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class Paquete(
    var tema: String,
    var palabras: MutableList<String> = mutableListOf()
)

@Composable
fun PaquetesPage(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally ,



    ) {
        var listaDePaquetes = remember  {obtenerPaquetes()}

        Introduccion(Modifier.weight(20f) , navController)
        ListaDePaquetes(Modifier.weight(80f) , listaDePaquetes as MutableList<Paquete>)

    }
}

@Composable
fun Introduccion(modifier : Modifier , navController: NavController){
    Text(text = "Seleccionar paquetes " ,
        color = Color.White)


}

@Composable
fun ListaDePaquetes( modifier : Modifier , paquetes : MutableList<Paquete>){

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        items(paquetes) { paquete ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        border = BorderStroke(width = 2.dp, color = Color.White),
                        shape = RoundedCornerShape(50.dp)
                    )
                    .padding(20.dp)
                    .padding(horizontal = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = paquete.tema,
                    color = Color.White
                )
                Checkbox(
                    checked = true,
                    onCheckedChange = {}
                )
            }
        }
    }
}
fun sumarPaquete(){

}
