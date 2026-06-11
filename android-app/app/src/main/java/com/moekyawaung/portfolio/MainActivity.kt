package com.moekyawaung.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.ui.graphics.Color
import com.moekyawaung.portfolio.ui.screens.HomeScreen
import com.moekyawaung.portfolio.theme.NeonColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            MaterialTheme(
                colors = darkColors(
                    primary = NeonColors.neonCyan,
                    secondary = NeonColors.neonPink,
                    background = NeonColors.backgroundDark,
                    surface = NeonColors.surfaceDark,
                )
            ) {
                HomeScreen()
            }
        }
    }
}
