package com.example.kviz.model

class Kviz {


    //Pitanja
    private var prvoPitanje: Pitanje =
        Pitanje("Pariz je glavni grad Njemacke", false)
    private var drugoPitanje: Pitanje =
        Pitanje("Sarajevo je glavni grad Spanije", false)
    private var trecePitanje: Pitanje =
        Pitanje("London je glavni grad Engleske", true)
    private var cetvrtoPitanje: Pitanje =
        Pitanje("Zagreb je glavni grad Hrvatske", true)
    private var petoPitanje: Pitanje =
        Pitanje("Sao Paolo je glavni grad Brazila", true)

    var pitanja: List<Pitanje> = listOf(prvoPitanje, drugoPitanje, trecePitanje, cetvrtoPitanje, petoPitanje)
}