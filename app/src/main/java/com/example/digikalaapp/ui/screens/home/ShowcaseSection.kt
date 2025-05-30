package com.example.digikalaapp.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.digikalaapp.R
import com.example.digikalaapp.navigation.Screen
import com.example.digikalaapp.ui.components.RoundedIconBox
import com.example.digikalaapp.ui.theme.LocalSpacing
import com.example.digikalaapp.ui.theme.amber
import com.example.digikalaapp.ui.theme.grayCategory
import com.example.digikalaapp.util.Constants.AUCTION_URL
import com.example.digikalaapp.util.Constants.DIGIJET_URL
import com.example.digikalaapp.util.Constants.DIGIPAY_URL
import com.example.digikalaapp.util.Constants.DIGIPLUS_URL
import com.example.digikalaapp.util.Constants.GIFT_CARD_URL
import com.example.digikalaapp.util.Constants.MORE_URL
import com.example.digikalaapp.util.Constants.PINDO_URL
import com.example.digikalaapp.util.Constants.SHOPPING_URL

@Composable
fun ShowcaseSection(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = LocalSpacing.current.semiMedium,
                vertical = LocalSpacing.current.biggerSmall
            )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = LocalSpacing.current.semiSmall),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            RoundedIconBox(
                image = painterResource(R.drawable.digijet),
                title = stringResource(R.string.digikala_jet), onClick = onBoxClick(
                    navController = navController,
                    url = DIGIJET_URL
                )
            )


            RoundedIconBox(
                image = painterResource(R.drawable.auction),
                title = stringResource(R.string.digi_style), onClick = onBoxClick(
                    navController = navController,
                    url = AUCTION_URL
                )
            )

            RoundedIconBox(
                image = painterResource(R.drawable.digipay),
                title = stringResource(R.string.digi_pay),
                onClick = onBoxClick(
                    navController,
                    url = DIGIPAY_URL
                ),
            )



            RoundedIconBox(
                image = painterResource(R.drawable.pindo),
                title = stringResource(R.string.pindo),
                bgColor = MaterialTheme.colors.amber,
                onClick = onBoxClick(
                    navController,
                    url = PINDO_URL
                ),
            )


        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = LocalSpacing.current.semiSmall),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            RoundedIconBox(
                image = painterResource(R.drawable.shopping),
                title = stringResource(R.string.digi_shopping),
                onClick = onBoxClick(
                    navController,
                    url = SHOPPING_URL
                ),
            )



            RoundedIconBox(
                image = painterResource(R.drawable.giftcard),
                title = stringResource(R.string.gift_card),
                onClick = onBoxClick(
                    navController,
                    url = GIFT_CARD_URL
                )

            )


            RoundedIconBox(
                image = painterResource(R.drawable.digiplus),
                title = stringResource(R.string.digi_plus),
                onClick = onBoxClick(
                    navController,
                    url = DIGIPLUS_URL
                ),
            )



            RoundedIconBox(
                image = painterResource(R.drawable.more),
                title = stringResource(R.string.more),
                bgColor = MaterialTheme.colors.grayCategory, onClick = onBoxClick(
                    navController,
                    url = MORE_URL
                )
            )

        }


    }
}

@Composable
fun onBoxClick(navController: NavHostController, url: String): () -> Unit = {
    navController.navigate(route = Screen.WebView.route + "?url=${url}")
}

