package com.example.digikalaapp.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.digikalaapp.R
import com.example.digikalaapp.ui.theme.selectedBottomBar
import com.example.digikalaapp.ui.theme.unSelectedBottomBar
import com.example.digikalaapp.util.Constants.USER_LANGUAGE
import com.example.digikalaapp.util.LocaleUtils

@Composable
fun BottomNavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    LocaleUtils.setLocale(LocalContext.current, USER_LANGUAGE)

    val items = listOf(
        BottomNavItem(
            name = stringResource(R.string.home),
            route = Screen.Home.route,
            selectedIcon = painterResource(R.drawable.home_fill),
            deSelectedIcon = painterResource(R.drawable.home_outline)
        ),
        BottomNavItem(
            name = stringResource(R.string.category),
            route = Screen.Category.route,
            selectedIcon = painterResource(R.drawable.category_fill),
            deSelectedIcon = painterResource(R.drawable.category_outline)
        ),
        BottomNavItem(
            name = stringResource(R.string.basket),
            route = Screen.Basket.route,
            selectedIcon = painterResource(R.drawable.cart_fill),
            deSelectedIcon = painterResource(R.drawable.cart_outline)
        ),
        BottomNavItem(
            name = stringResource(R.string.my_digikala),
            route = Screen.Profile.route,
            selectedIcon = painterResource(R.drawable.user_fill),
            deSelectedIcon = painterResource(R.drawable.user_outline)
        )
    )

    val backStackEntry = navController.currentBackStackEntryAsState()
    val showBottomBar = backStackEntry.value?.destination?.route in items.map { it.route }

    if (showBottomBar) {
        BottomNavigation(
            modifier = Modifier,
            backgroundColor = Color.White,
            elevation = 5.dp

        ) {
            items.forEachIndexed { index, item ->
                val selected = item.route == backStackEntry.value?.destination?.route

                BottomNavigationItem(
                    selected = selected,
                    onClick = { onItemClick(item) },
                    selectedContentColor = MaterialTheme.colors.selectedBottomBar,
                    unselectedContentColor = MaterialTheme.colors.unSelectedBottomBar,
                    icon = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            if (selected) {
                                Icon(
                                    modifier = Modifier.height(24.dp),
                                    painter = item.selectedIcon,
                                    contentDescription = item.name
                                )
                            } else {
                                Icon(
                                    modifier = Modifier.height(24.dp),
                                    painter = item.deSelectedIcon,
                                    contentDescription = item.name
                                )
                            }
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.h6,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 5.dp)
                            )
                        }
                    }
                )
            }
        }
    }

}