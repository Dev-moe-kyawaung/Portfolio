// app/src/main/java/com/moekyawaung/portfolio/ui/components/SkillProgressBar.kt
package com.moekyawaung.portfolio.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SkillProgressBar(
  name: String,
  percentage: Int,
  color: Color = NeonColors.neonCyan
) {
  Column(modifier = Modifier.padding(bottom = 20.dp)) {
    Row {
      Text(
        text = name,
        style = MaterialTheme.typography.body1,
        modifier = Modifier.weight(1f)
      )
      Text(
        text = "$percentage%",
        style = MaterialTheme.typography.body1,
        color = color
      )
    }
    
    Spacer(modifier = Modifier.height(8.dp))
    
    // Progress Bar
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(8.dp)
        .background(
          color = NeonColors.surfaceDark2,
          shape = RoundedCornerShape(4.dp)
        )
    ) {
      Box(
        modifier = Modifier
          .fillMaxWidth(percentage / 100f)
          .height(8.dp)
          .background(
            color = color,
            shape = RoundedCornerShape(4.dp)
          )
      )
    }
  }
}
