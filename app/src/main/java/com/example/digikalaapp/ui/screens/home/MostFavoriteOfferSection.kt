package com.example.digikalaapp.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikalaapp.R
import com.example.digikalaapp.data.model.home.StoreProduct
import com.example.digikalaapp.data.remote.NetworkResult
import com.example.digikalaapp.ui.theme.DarkCyan
import com.example.digikalaapp.ui.theme.darkText
import com.example.digikalaapp.ui.theme.spacing
import com.example.digikalaapp.viewmodel.HomeViewModel

@Composable
fun MostFavoriteOfferSection(
    viewModel: HomeViewModel = hiltViewModel()
) {
    var mostFavoriteList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val mostFavoriteResult by viewModel.mostFavoriteItem.collectAsState()
    when (mostFavoriteResult) {
        is NetworkResult.Success -> {
            mostFavoriteList = mostFavoriteResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "Most Favorite Error:  ${mostFavoriteResult.message}")
        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.small)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.extraSmall),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.favorite_product),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h3,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.darkText
            )

            Text(

                text = stringResource(R.string.see_all),
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.DarkCyan
            )
        }


        LazyRow {
            items(mostFavoriteList) { item ->

                MostFavoriteProductsOffer(item)
            }
            item {
                MostFavoriteProductsOfferShowMore()
            }
        }


    }
}
