package com.jceferino.cc3087_labs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.jceferino.cc3087_labs.ui.theme.Cc3087labsTheme
import com.jceferino.cc3087_labs.data.articulosDeEjemplo
import com.jceferino.cc3087_labs.ui.screens.InicioScreen
/*
  José Carlos Ceferino Fabián, 251043
* Uso de AI, Claude fue usado como guía para el diseño de componentes y para el
* entendimiento y explicación de diversas funciones.
*
*Pregunta 1: al quitar el weight del column, desaparece el cuadro de color del artículo,
* esto debido a que sin el weight la columna no tiene manera de distruibuir correctamente
* el espacio que comparten el texto y el cuadro. Por lo que este último desaparece al tener
* el espacio del texto más contenido.
*
* Pregunta 2: el artículo recibe el modifier por parámetro porque de esta manera el margen
* puede ser un valor dinámico en lugar de estático. Si el margen se fijara adentro de este, el
* espacio que ocupa el articulo sería exactamente igual en dos pantallas con espaciados distintos.
* */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cc3087labsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InicioScreen(
                        articulos = articulosDeEjemplo,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
