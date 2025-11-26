package com.example.impostorgame

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import kotlin.math.roundToInt
import kotlin.random.Random

@Composable
fun JuegoPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 50.dp) ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center
    ) {
        InicioJuego(Modifier.weight(20f))
        PageJugador( Modifier.weight(80f))
    }
}
fun EleccionPalabra() : String{
    var todasOpciones : ArrayList<String> = ArrayList<String>();
    var palabra = ""
    Variables.paquetesUsuario.forEach { paquete ->
        todasOpciones.addAll(paquete.palabras)


    }
    var numAleatorio = Random.nextInt(0 , todasOpciones.size)
    palabra = todasOpciones.get(numAleatorio)
    return palabra

}
@Composable
fun InicioJuego(modifier: Modifier ){
    Column (modifier = modifier
        .fillMaxSize() ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center
    ){

        Text(text =  "EL IMPOSTOR" ,
            color = Color.White)
    }

}
@Composable
fun PageJugador( modifier: Modifier = Modifier) {
    val offset = remember { Animatable(Offset.Zero, Offset.VectorConverter) }
    val scope = rememberCoroutineScope()
    val palabraSecreta = remember { EleccionPalabra() }
    var indice  by remember{ mutableIntStateOf(0) }



    Column(modifier = modifier ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center
    )  {

        if (Variables.listaJugadores.size > indice && Variables.listaJugadores.isNotEmpty()){
            val jugadorActual = Variables.listaJugadores[indice]

            Text(
                text = "Te toca a ti,",
                color = Color.White

                )
            Text(
                text = jugadorActual.nombre.uppercase(),
                color = Color.Red,
                modifier = Modifier.padding(bottom = 30.dp)
            )

            Box(
                modifier = Modifier
                    .size(200.dp, 200.dp)
                    .background(color = Color.Red),
                contentAlignment = Alignment.Center

            ) {



                if (jugadorActual.rol == Rol.CIVIL){
                    Text(text = "Eres  " + jugadorActual.rol  ,
                        color = Color.White )
                    Text(text = "la palabra secreta es " + palabraSecreta ,
                        color = Color.White)

                }else
                    Text("eres impostor, disimula ...")


                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .offset {
                            IntOffset(offset.value.x.roundToInt(), offset.value.y.roundToInt())
                        }
                        .background(Color.Yellow)
                        .pointerInput(Unit) {
                            detectDragGestures(
                                onDrag = { change, dragAmount ->
                                    change.consume()
                                    scope.launch {
                                        offset.snapTo(offset.value + dragAmount)
                                    }
                                },
                                onDragEnd = {
                                    scope.launch {
                                        offset.animateTo(
                                            targetValue = Offset.Zero,
                                            animationSpec = spring(dampingRatio = 0.6f, stiffness = 300f)
                                        )
                                    }
                                }
                            )
                        }
                )

            }
            Button(
                onClick = {
                    indice = indice +1 ;
                },
                modifier = Modifier
                    .padding(vertical = 100.dp)

            ) {
                Text("pasar al siguiente jugador ")

            }

        }
    }
}