package com.example.compose_ecommerce.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose_ecommerce.view.DashboardScreen
import com.example.compose_ecommerce.view.ProductDetailsScreen
import com.example.compose_ecommerce.view.SplashScreen
import com.example.compose_ecommerce.view.ProductListScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(Screen.DashboardScreen.route) {
            DashboardScreen(navController = navController)
        }

        composable(Screen.ProductListScreen.route) {
            ProductListScreen()
        }

        composable(Screen.ProductDetailScreen.route) {
            ProductDetailsScreen(navController = navController)
        }
    }
}










