package com.example.impostorgame

fun obtenerPaquetes(): List<Paquete>{
    return listOf(
        Paquete(
            tema = "Garito" ,
            palabras = mutableListOf("Xabi" , "Moreno" , "Gorka" , "Egoitz" , "Pollete" , "Marlon" , "Jhonantan "
            , "Marcos" , "Mikel" , "Inchusta" , "Taju" , "Lacabe" , "Sufian" , "Jambo" ,
                "Llucia" , "David" , "Amurrio")

        ),
        Paquete(
            tema = "Comida",
            palabras = mutableListOf("Pizza", "Hamburguesa", "Sushi", "Tacos", "Paella")
        )



    )

}
/*fun iniciarPartida(): Partida{
    var partida = Partida()
    return


}*/