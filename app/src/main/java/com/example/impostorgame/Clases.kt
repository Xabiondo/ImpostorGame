package com.example.impostorgame

import androidx.compose.runtime.MutableState

class Jugador(nombre: MutableState<String>) {
    var nombre : String = "";
    var rol : Rol = Rol.CIVIL;

}
class Impostor(){
    var nombre : String = "" ;
    var rol : Rol = Rol.IMPOSTOR;
}
class Partida (
    var jugadores : MutableList<Jugador> ,
    var paquetes: MutableList<Paquete>
)

data class Paquete(
    var tema: String,
    var palabras: MutableList<String> = mutableListOf()
)
