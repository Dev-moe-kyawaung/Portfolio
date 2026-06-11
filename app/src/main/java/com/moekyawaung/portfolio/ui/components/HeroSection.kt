package com.moekyawaung.portfolio.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import com.moekyawaung.portfolio.theme.NeonColors

@Composable
fun HeroSection(
  name: String = "Moe Kyaw Aung",
  tagline: String = "⭐ ANDROID SENIOR DEVELOPER ⭐"
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(24.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    // Tagline
    Text(
      text = tagline,
      style = MaterialTheme.typography.button,
      color = NeonColors.neonYellow,
      letterSpacing = 2f
    )
    
    Spacer(modifier = Modifier.height(16.dp))
    
    // Name with gradient
    Text(
      text = name,
      style = TextStyle(
        fontSize = 48.sp,
        fontWeight = FontWeight.Bold
      ),
      brush = Brush.horizontalGradient(
        colors = listOf(
          NeonColors.neonCyan,
          NeonColors.neonPink,
          NeonColors.neonYellow
        )
      )
    )
  }
}
