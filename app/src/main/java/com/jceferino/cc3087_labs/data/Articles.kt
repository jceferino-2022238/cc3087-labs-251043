package com.jceferino.cc3087_labs.data

import com.jceferino.cc3087_labs.model.Article

val articulosDeEjemplos: List<Article> = listOf(
    Article(
        author = "Pedro Sánchez",
        title = "¿Qué esperar del avance de la IA en los siguientes 20 años?",
        excerpt = "La IA avanza a pasos gigantes y pocas personas pueden deducir realmente que se " +
                "puede esperar de su avance en el tiempo próximo ",
        readingMinutes = 10,
        date = "9 aug",
        isAuthorFollowed = true,
        isFeatured = false
    ),
    Article(
        author = "Andrés Iniesta",
        title = "Solución para refrigegración líquida",
        excerpt = "Comparto una guía de soluciones comunes para su uso en la refrigeración " +
                "líquida de sistemas computacionales",
        readingMinutes = 5,
        date = "7 jul",
        isAuthorFollowed = false,
        isFeatured = true
    ),
    Article(
        author = "Lionel Messi",
        title = "Guía de iPhones 2026",
        excerpt = "Si no sabes que iPhone comprar en pleno 2026, traigo aquí una tierlist " +
                "de los mejores iPhones que puedes comprar actualmente",
        readingMinutes = 5,
        date = "3 mar",
        isAuthorFollowed = false,
        isFeatured = true
    )
)