package com.jceferino.cc3087_labs.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val tabsNames = listOf ("Para ti", "Siguiendo", "Destacados")

@Composable
fun TabsRow(
    selectedTab: String,
    onTabSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
       tabsNames.forEach{ name ->
           val isSeleceted = name == selectedTab
           Text(
               text = name,
               color = if(isSeleceted) Color.White else Color(0xFF9A9A9A),
               fontWeight = if (isSeleceted) FontWeight.Bold else FontWeight.Normal,
               fontSize = 14.sp,
               modifier = Modifier.clickable{ onTabSelected(name) }
           )

       }
    }
}