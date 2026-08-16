package com.jceferino.cc3087_labs

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.jceferino.cc3087_labs.ui.theme.Cc3087labsTheme
import com.jceferino.cc3087_labs.data.articulosDeEjemplos
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
*

Uso de AI en el Laboratorio 6: Calude fue usado como guía para entender el funcionamiento de los
comportamientos de las pestañas, implementación de lógica y diseño de la nueva screen y explicación
de la lógica remember/saveable
*/

class MainActivity : ComponentActivity() {
    companion object {
        private const val TAG = "LAB6_251043"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContent {
            Cc3087labsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InicioScreen(
                        articles = articulosDeEjemplos,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}
