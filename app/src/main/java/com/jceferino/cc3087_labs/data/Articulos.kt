package com.jceferino.cc3087_labs.data

import com.jceferino.cc3087_labs.model.Articulo

val articulosDeEjemplo: List<Articulo> = listOf(
    Articulo(
        autor = "Pedro Sánchez",
        titulo = "¿Qué esperar del avance de la IA en los siguientes 20 años?",
        extracto = "La IA avanza a pasos gigantes y pocas personas pueden deducir realmente que se " +
                "puede esperar de su avance en el tiempo próximo ",
        minutosLectura = 10,
        fecha = "9 aug"
    ),
    Articulo(
        autor = "Andrés Iniesta",
        titulo = "Solución para refrigegración líquida",
        extracto = "Comparto una guía de soluciones comunes para su uso en la refrigeración " +
                "líquida de sistemas computacionales",
        minutosLectura = 5,
        fecha = "12 dic"
    ),
    Articulo(
        autor = "Lionel Messi",
        titulo = "Guía de iPhones 2026",
        extracto = "Si no sabes que iPhone comprar en pleno 2026, traigo aquí una tierlist " +
                "de los mejores iPhones que puedes comprar actualmente",
        minutosLectura = 5,         
        fecha = "12 dic"
    )
)