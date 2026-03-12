package com.abel.anothertest.UIapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abel.anothertest.SignInScreen
import com.abel.anothertest.UIapp.screen.login.MainScreen
import com.abel.anothertest.screens.SignUpScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "main",
        modifier = modifier
    ) {

        composable("main") {
            MainScreen(
                onSignInClick = { navController.navigate("signIn") },
                onSignUpClick = { navController.navigate("signUp") }
            )
        }

        composable("signIn") {
            SignInScreen(
                onBack = { navController.popBackStack() }
            )
        }

        composable("signUp") {
            SignUpScreen(
                onBack = { navController.popBackStack() },
                onSignUpSuccess = {
                    navController.navigate("main")
                }
            )
        }
    }
}