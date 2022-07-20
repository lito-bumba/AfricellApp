package com.litobumba.africellapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = Telas.Splash.rota) {

                composable(route = Telas.Splash.rota) {
                    TelaSplash { navController.navigate(Telas.Login.rota) }
                }

                composable(route = Telas.Login.rota) {
                    TelaLogin { navController.navigate(Telas.Principal.rota) }
                }

                composable(route = Telas.Principal.rota) { TelaPrincipal() }
            }

        }
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}

sealed class Telas(val rota: String) {
    object Splash : Telas("splash")
    object Login : Telas("login")
    object Principal : Telas("principal")
}