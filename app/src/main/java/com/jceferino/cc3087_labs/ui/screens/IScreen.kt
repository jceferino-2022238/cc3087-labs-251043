package com.jceferino.cc3087_labs.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jceferino.cc3087_labs.model.Article
import com.jceferino.cc3087_labs.ui.components.Separator
import com.jceferino.cc3087_labs.ui.components.TabsRow
import com.jceferino.cc3087_labs.ui.components.UpperBar
import androidx.compose.ui.tooling.preview.Preview
import com.jceferino.cc3087_labs.data.articulosDeEjemplos
import com.jceferino.cc3087_labs.ui.components.ArticleItem

private val avatarColors = listOf(
    Color(0xFFCC6633),
    Color(0xFF4A7A9D),
    Color(0xFFAA5588)
)
private val miniatureColors = listOf(
    Color(0xFF6B5B29),
    Color(0xFF5C6B3C),
    Color(0xFF9C7A2E)
)

@Composable

fun InicioScreen(

    articles: List<Article>,
    modifier: Modifier = Modifier
) {
    var searchQuery by rememberSaveable{mutableStateOf("") }
    var selectedTab by rememberSaveable { mutableStateOf("Para ti") }
    var showShortReadsOnly by rememberSaveable{ mutableStateOf(false)}

    var applauseCount by rememberSaveable{ mutableStateOf(0) }

    val results: List<Article> = articles.filter { article ->
        val coincidenceWithTab = when (selectedTab){
            "Siguiendo" -> article.isAuthorFollowed
            "Destacados" -> article.isFeatured
            else -> true
        }
        val coincidenceWithSearch = article.title.contains(searchQuery, ignoreCase = true) ||
                article.author.contains(searchQuery, ignoreCase = true)
        val coincidenceWithShortFilter = if (showShortReadsOnly) article.readingMinutes <= 5 else true

        coincidenceWithTab && coincidenceWithSearch && coincidenceWithShortFilter
    }

    val cantidadResultados = results.size
    // Todo esta dentro de este column
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .verticalScroll(rememberScrollState())
    ) {
        UpperBar(nombreApp = "Lecturas")
        TabsRow(
            selectedTab = selectedTab,
            onTabSelected = { newTab -> selectedTab = newTab }
        )
        Separator()

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Buscar por título o autor") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Switch(
                    checked = showShortReadsOnly,
                    onCheckedChange = { showShortReadsOnly = it }
                )
                Text(
                    text = "Solo lecturas cortas",
                    modifier = Modifier.padding(start = 8.dp),
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
            Text(
                text = if (cantidadResultados == 1) "1 resultado" else "$cantidadResultados resultados",
                color = Color(0xFF6AA9E9),
                fontSize = 13.sp
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = { applauseCount++ }) {
                Text("Aplaudir · $applauseCount")
            }
        }

        Separator()

        if (results.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "No se encontraron artículos",
                    color = Color.White,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Cambia la pestaña, la búsqueda o el filtro.",
                    color = Color(0xFF9A9A9A),
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center
                )
            }
        } else {
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                results.forEachIndexed { index, article ->
                    ArticleItem(
                        article = article,
                        colorAvatar = avatarColors[index % avatarColors.size],
                        colorMiniatura = miniatureColors[index % miniatureColors.size]
                    )
                    if (index != results.lastIndex) {
                        Separator()
                    }
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