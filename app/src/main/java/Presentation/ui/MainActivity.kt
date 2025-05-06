package Presentation.ui

import Presentation.theme.BaTimeTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaTimeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = TODO()
                )
            }
        }
    }
}


@Composable
fun a(modifier: Modifier = Modifier.fillMaxSize()){

}