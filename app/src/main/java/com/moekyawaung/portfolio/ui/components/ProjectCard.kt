// app/src/main/java/com/moekyawaung/portfolio/ui/components/ProjectCard.kt
package com.moekyawaung.portfolio.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Project(
  val title: String,
  val description: String,
  val tags: List<String>
)

@Composable
fun ProjectCard(project: Project) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 8.dp),
    elevation = 4.dp
  ) {
    Column(
      modifier = Modifier
        .padding(16.dp)
        .verticalScroll(rememberScrollState())
    ) {
      Text(
        text = project.title,
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.Bold
      )
      
      Spacer(modifier = Modifier.height(8.dp))
      
      Text(
        text = project.description,
        style = MaterialTheme.typography.body1,
        color = NeonColors.textMuted
      )
      
      Spacer(modifier = Modifier.height(12.dp))
      
      // Tags
      project.tags.forEach { tag ->
        Text(
          text = tag,
          style = MaterialTheme.typography.body2,
          color = NeonColors.neonCyan,
          modifier = Modifier
            .background(
              color = NeonColors.neonCyan-opacity(0.1),
              shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
        )
      }
    }
  }
}
