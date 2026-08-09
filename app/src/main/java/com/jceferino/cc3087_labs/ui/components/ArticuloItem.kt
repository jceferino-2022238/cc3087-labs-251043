package com.jceferino.cc3087_labs.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.jceferino.cc3087_labs.model.Articulo

@Composable
fun ArticuloItem(
    articulo: Articulo,
    colorAvatar: Color,
    colorMiniatura: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(16.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            // Primera columna con todo lo que sea texto y metadata
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(colorAvatar)
                )
                Text(
                    text = articulo.autor,
                    modifier = Modifier.padding(start = 8.dp),
                    color = Color.White,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = articulo.titulo,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = articulo.extracto,
                color = Color(0xFFAAAAAA),
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Text(
                    text = "${articulo.minutosLectura} min de lectura",
                    color = Color(0xFF888888),
                    fontSize = 12.sp
                )
                Text(
                    text = " · ",
                    color = Color(0xFF888888),
                    fontSize = 12.sp
                )
                Text(
                    text = articulo.fecha,
                    color = Color(0xFF888888),
                    fontSize = 12.sp
                )
            }
        }
        // La miniatura
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(colorMiniatura)
        )
    }
}

