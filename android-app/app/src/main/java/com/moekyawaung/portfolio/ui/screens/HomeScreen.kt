package com.moekyawaung.portfolio.ui.screens

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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import com.moekyawaung.portfolio.theme.NeonColors

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Tagline
        Text(
            text = "⭐ ANDROID SENIOR DEVELOPER ⭐",
            style = MaterialTheme.typography.button,
            color = NeonColors.neonYellow,
            letterSpacing = 2f,
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Name
        Text(
            text = "Moe Kyaw Aung",
            style = TextStyle(
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
            ),
            brush = Brush.horizontalGradient(
                colors = listOf(NeonColors.neonCyan, NeonColors.neonPink, NeonColors.neonYellow)
            ),
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Stats
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatItem("12+", "Years")
            StatItem("3K+", "Apps")
            StatItem("22", "Repos")
            StatItem("100%", "Sat")
        }
    }
}

@Composable
fun StatItem(value: String, label: String) {
    Column(
        modifier = Modifier
            .background(
                color = NeonColors.surfaceDark.withOpacity(0.7),
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
