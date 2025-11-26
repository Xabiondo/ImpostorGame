package com.example.impostorgame


import android.os.Bundle
import android.provider.CalendarContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.impostorgame.ui.theme.ImpostorGameTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImpostorGameTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "juego"
                ) {

                    composable("pantalla_principal") {
                        PantallaPrincipal(navController)
                    }
                    composable("paquetes") {
                        PaquetesPage(navController)
                    }
                    composable("inicio_juego") {
                        PreviaPage(navController)
                    }
                    composable ("juego") {
                        JuegoPage(navController)


                    }

                }

            }
        }
    }
}
@Composable
fun PantallaPrincipal( navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black),

        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center

    ) {
        Inicio(Modifier.weight(20f))
        Menu(Modifier.weight(60f) ,navController  )
        Footer(Modifier.weight(20f) , navController)

    }
}


@Composable
fun Inicio(modifier :  Modifier){
    Column(modifier = modifier ,
         horizontalAlignment =  Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center) {

        Text(
            text = "El impostor" ,
            color = Color.Red,
            fontSize = 24.sp
        )
        Image(
            painter = painterResource( R.drawable.impostor1) ,
            contentDescription = "impostor" ,
            modifier = Modifier.size(50.dp))
    }

}
@Composable
fun Menu(modifier : Modifier , navController: NavController ){

    Column(modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 32.dp) ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.SpaceEvenly ,

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(border = BorderStroke(width = 2.dp , color = Color.White),
                    shape = RoundedCornerShape(50.dp))
                .padding(20.dp)
                .padding(horizontal = 30.dp) ,
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.Center
        ){
            Text(text = "Modo de juego " ,
                color = Color.White)

            Button(
                onClick = {} ,

            ) {
                Text(
                    text = " > "
                )
            }
        }

        Column(modifier = Modifier.
        border(border = BorderStroke(2.dp , color = Color.White) ,
            shape = RoundedCornerShape(50.dp))
        ) {

            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .padding(horizontal = 30.dp)
                ,
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.SpaceEvenly

            ) {

                Text(text = "Jugadores " ,
                    color = Color.White )
                Button(onClick = { Variables.jugadores-- ;
                                if (Variables.jugadores / Variables.impostores < 2){
                                    Variables.impostores--}
                }
                , modifier = Modifier
                        .size(height = 40.dp , width = 40.dp),
                contentPadding = PaddingValues(0.dp)

                ) {
                    Text(text = " - ")
                }
                Text(
                    text = Variables.jugadores.toString(),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
                Button(onClick = {Variables.jugadores++},
                    modifier = Modifier
                        .size(height = 40.dp , width = 40.dp)
                ,contentPadding = PaddingValues(0.dp))
                {
                    Text(text = " + ")
                }

            }
            HorizontalDivider(
                thickness = 2.dp ,
                color = Color.Gray
            )


            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .padding(horizontal = 30.dp)
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Impostores " ,
                    color = Color.White )
                Button(onClick = {
                    Variables.impostores--

                }
                    , modifier = Modifier
                        .size(height = 40.dp , width = 40.dp),
                    contentPadding = PaddingValues(0.dp)

                ) {
                    Text(text = " - ")
                }
                Text(
                    text = Variables.impostores.toString(),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
                Button(onClick = {
                    if (Variables.jugadores / Variables.impostores >2){
                    Variables.impostores++
                }},
                    modifier = Modifier
                        .size(height = 40.dp , width = 40.dp)
                    ,contentPadding = PaddingValues(0.dp))
                {
                    Text(text = " + ")
                }
            }

        }
        Column(modifier = Modifier.
        border(border = BorderStroke(2.dp , color = Color.White) ,
            shape = RoundedCornerShape(50.dp) )
            .fillMaxWidth()
        ) {

            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .padding(horizontal = 30.dp),
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Paquetes ",
                    color = Color.White
                )

                Button(
                    onClick = {navController.navigate("paquetes")},
                    modifier = Modifier
                        .size(height = 40.dp, width = 40.dp), contentPadding = PaddingValues(0.dp)
                )
                {
                    Text(text = " > ")
                }

            }
            HorizontalDivider(
                thickness = 2.dp ,
                color = Color.Gray
            )

            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .padding(horizontal = 30.dp),
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Duración ",
                    color = Color.White
                )
                Button(onClick = {}, modifier = Modifier
                    .size(height = 40.dp, width = 40.dp),
                    contentPadding = PaddingValues(0.dp)

                ) {
                    Text(text = " > ")
                }

            }
        }
    }
}

@Composable
fun Footer(modifier: Modifier , navController: NavController) {
    Column(
        modifier = modifier.fillMaxWidth(),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                if (Variables.jugadores < 1 || Variables.impostores < 1 || Variables.paquetesUsuario.isEmpty()){
                    return@Button

                }
                    navController.navigate("inicio_juego")},
        ) {
            Text("Iniciar el juego ")
        }
    }
}