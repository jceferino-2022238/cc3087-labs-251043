package com.jceferino.cc3087_labs.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BarraSuperior(
    nombreApp: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Primer grupo, el logo y nombre
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFEDEDED)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "M",
                    color = Color(0xFF121212),
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = nombreApp,
                modifier = Modifier.padding(start = 12.dp),
                color = Color.White,
                fontSize = 18.sp
            )
        }

        // Segundo grupo, accion y pefil
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Escribir",
                color = Color.White,
                fontSize = 14.sp
            )
            Box(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF3C9B5C))
            )
        }
    }
}