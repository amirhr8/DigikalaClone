package com.example.digikalaapp.ui.screens.basket


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.digikalaapp.R
import com.example.digikalaapp.ui.theme.digikalaRed
import com.example.digikalaapp.ui.theme.spacing
import com.example.digikalaapp.viewmodel.BasketViewModel

@Composable
fun BasketScreen(navController: NavHostController) {
    Basket(navController)

}

@Composable
fun Basket(
    navController: NavController,
    viewModel: BasketViewModel = hiltViewModel()
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    val tabTitle = listOf(
        stringResource(id = R.string.cart),
        stringResource(id = R.string.next_cart_list)
    )

    Column {
        TabRow(
            modifier = Modifier.padding(MaterialTheme.spacing.medium),
            selectedTabIndex = selectedTabIndex,
            contentColor = MaterialTheme.colors.digikalaRed,
            backgroundColor = Color.White,
            indicator = { line ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(line[selectedTabIndex])
                        .height(3.dp)
                        .background(Color.Red)

                )
            }
        ) {
            tabTitle.forEachIndexed { index, title ->
                Tab(
                    selected = (selectedTabIndex == index),
                    onClick = {
                        selectedTabIndex = index
                    },
                    selectedContentColor = MaterialTheme.colors.digikalaRed,
                    unselectedContentColor = Color.Gray,
                    text = {
                        Row {
                            Text(
                                text = title,
                                style = MaterialTheme.typography.h6,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                )
            }

        }

        when (selectedTabIndex) {
            0 -> ShoppingCard()
            1 -> NextShoppingList()
        }
    }

}
