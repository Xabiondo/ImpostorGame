package com.example.impostorgame

class Jugador(nombre: String) {
    var nombre : String = nombre;
    var rol : Rol = Rol.CIVIL;

}
class Partida (
    var jugadores : MutableList<Jugador> ,
    var paquetes: MutableList<Paquete>
)

data class Paquete(
    var tema: String,
    var palabras: MutableList<String> = mutableListOf()
)
