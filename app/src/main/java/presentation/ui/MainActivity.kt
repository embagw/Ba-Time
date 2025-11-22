package presentation.ui

import presentation.theme.BaTimeTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import navigation.AppNavGraph

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaTimeTheme {
                val navController = rememberNavController()
                AppNavGraph(navController = navController)
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { padding ->
                    // matn dakhel navbary
                    Text("ui kar mikonad")
                    AppNavGraph(
                        navController = navController,
                        modifier = Modifier.padding(padding)
                    )
                }
            }
        }
    }
}


@Composable
fun a(modifier: Modifier = Modifier.fillMaxSize()){

}