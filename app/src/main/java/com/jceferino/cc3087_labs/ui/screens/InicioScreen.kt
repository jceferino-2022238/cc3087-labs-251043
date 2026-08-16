package com.jceferino.cc3087_labs.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.jceferino.cc3087_labs.model.Article
import com.jceferino.cc3087_labs.ui.components.Separador
import com.jceferino.cc3087_labs.ui.components.ArticuloItem
import com.jceferino.cc3087_labs.ui.components.FilaPestanas
import com.jceferino.cc3087_labs.ui.components.BarraSuperior

import androidx.compose.ui.tooling.preview.Preview
import com.jceferino.cc3087_labs.data.articulosDeEjemplos
private val coloresAvatar = listOf(
    Color(0xFFCC6633),
    Color(0xFF4A7A9D),
    Color(0xFFAA5588)
)
private val coloresMiniatura = listOf(
    Color(0xFF6B5B29),
    Color(0xFF5C6B3C),
    Color(0xFF9C7A2E)
)

@Composable
fun InicioScreen(
    articles: List<Article>,
    modifier: Modifier = Modifier
) {
    // Todo esta dentro de este column
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .verticalScroll(rememberScrollState())
    ) {
        BarraSuperior(nombreApp = "Lecturas")
        FilaPestanas()

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            articles.forEachIndexed { index, articulo ->
                ArticuloItem(
                    article = articulo,
                    colorAvatar = coloresAvatar[index % coloresAvatar.size],
                    colorMiniatura = coloresMiniatura[index % coloresMiniatura.size]
                )
                // Esto evita que haya un separador después del último artículo
                if (index != articles.lastIndex) {
                    Separador()
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun InicioScreenPreview(){
    InicioScreen(articles = articulosDeEjemplos)
}