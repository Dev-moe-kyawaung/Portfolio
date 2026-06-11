// app/src/main/java/com/moekyawaung/portfolio/ui/components/StatsCounter.kt
package com.moekyawaung.portfolio.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.moekyawaung.portfolio.theme.NeonColors

@Composable
fun StatsCounter(
  years: String = "12+",
  apps: String = "3K+",
  repos: String = "22",
  satisfaction: String = "100%"
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 24.dp),
    horizontalArrangement = Arrangement.SpaceEvenly
  ) {
    StatItem(years, "Years")
    StatItem(apps, "Apps")
    StatItem(repos, "Repos")
    StatItem(satisfaction, "Sat")
  }
}

@Composable
fun StatItem(value: String, label: String) {
  Column(
    modifier = Modifier
      .background(
        color = NeonColors.surfaceDark-opacity(0.7),
        shape = RoundedCornerShape(22.dp)
      )
      .padding(20.dp)
      .width(100.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      text = value,
      style = MaterialTheme.typography.h3,
      fontWeight = FontWeight.Bold,
      color = NeonColors.neonCyan
    )
    Text(
      text = label,
      style = MaterialTheme.typography.body2,
      color = NeonColors.textMuted,
      fontSize = 12.sp
    )
  }
}
