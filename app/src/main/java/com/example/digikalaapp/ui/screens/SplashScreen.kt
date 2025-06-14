package com.example.digikalaapp.ui.screens

import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.digikalaapp.R
import com.example.digikalaapp.navigation.Screen
import com.example.digikalaapp.ui.components.Loading3Dots
import com.example.digikalaapp.ui.theme.splashBg
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    Splash()
    LaunchedEffect(true) {
        delay(1500)
        navController.navigate(Screen.Home.route){
            popUpTo(Screen.Splash.route){
                inclusive = true
            }
        }
    }
}

@Composable
fun Splash() {

    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.splashBg)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(250.dp),
            painter = painterResource(id = R.drawable.digi_logo), contentDescription = null
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(100.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                modifier = Modifier.height(30.dp),
                painter = painterResource(id = R.drawable.digi_txt_white), contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.BottomCenter
        ) {

            Loading3Dots(false)
        }


    }
}