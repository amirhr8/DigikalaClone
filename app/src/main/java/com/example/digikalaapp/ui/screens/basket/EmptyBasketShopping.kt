package com.example.digikalaapp.ui.screens.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.digikalaapp.R
import com.example.digikalaapp.ui.theme.searchBarBg
import com.example.digikalaapp.ui.theme.semiDarkText
import com.example.digikalaapp.ui.theme.spacing

@Composable
fun EmptyBasketShopping() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = MaterialTheme.spacing.small),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(R.drawable.empty_cart),
            contentDescription = "",
            contentScale = ContentScale.FillBounds, modifier = Modifier.height(200.dp)
        )
    }

    Text(
        text = stringResource(R.string.cart_is_empty),
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.h6,
        color = MaterialTheme.colors.semiDarkText
    )

    Spacer(
        modifier = Modifier
            .height(MaterialTheme.spacing.small)
    )
}