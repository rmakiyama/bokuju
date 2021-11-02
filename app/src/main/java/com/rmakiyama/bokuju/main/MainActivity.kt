package com.rmakiyama.bokuju.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.rmakiyama.bokuju.ui.home.HomeScreen
import com.rmakiyama.bokuju.ui.theme.BokujuTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            BokujuTheme {
                ProvideWindowInsets(consumeWindowInsets = false) {
                    HomeScreen()
                }
            }
        }
    }
}
