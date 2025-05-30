package com.example.digikalaapp.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikalaapp.R
import com.example.digikalaapp.data.model.home.AmazingItem
import com.example.digikalaapp.data.remote.NetworkResult
import com.example.digikalaapp.ui.theme.DigikalaLightGreen
import com.example.digikalaapp.ui.theme.DigikalaLightRed
import com.example.digikalaapp.viewmodel.HomeViewModel

@Composable
fun SuperMarketOfferSection(
    viewModel: HomeViewModel = hiltViewModel()
) {
    var superMarketItemList by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val amazingItemResult by viewModel.supermarketAmazingItem.collectAsState()
    when (amazingItemResult) {
        is NetworkResult.Success -> {
            superMarketItemList = amazingItemResult.data ?: emptyList()
            loading = false
            Log.e("3636", "AmazingItemResult:  ${superMarketItemList[0].name}")
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "AmazingItemResult Error:  ${amazingItemResult.message}")
        }

        is NetworkResult.Loading -> {
            loading = true
        }

    }

    Column(modifier = Modifier.background(MaterialTheme.colors.DigikalaLightGreen)) {
        LazyRow(modifier = Modifier.background(MaterialTheme.colors.DigikalaLightGreen)) {
            item {
                AmazingOfferCard(R.drawable.supermarketamazings, R.drawable.fresh)
            }

            items(superMarketItemList) { item ->
                AmazingItem(item = item)
            }


            item {
                AmazingShowMoreItem()
            }
        }
    }

}