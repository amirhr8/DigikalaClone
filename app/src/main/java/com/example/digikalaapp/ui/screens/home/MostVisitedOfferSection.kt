package com.example.digikalaapp.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikalaapp.R
import com.example.digikalaapp.data.model.home.StoreProduct
import com.example.digikalaapp.data.remote.NetworkResult
import com.example.digikalaapp.ui.theme.darkText
import com.example.digikalaapp.ui.theme.spacing
import com.example.digikalaapp.util.DigitHelper.digitByLocate
import com.example.digikalaapp.viewmodel.HomeViewModel

@Composable
fun MostVisitedOfferSection(
    viewModel: HomeViewModel = hiltViewModel()
) {
    var mostVisitedList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val mostVisitedResult by viewModel.mostVisitedItem.collectAsState()
    when (mostVisitedResult) {
        is NetworkResult.Success -> {
            mostVisitedList = mostVisitedResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "MostVisited Error:  ${mostVisitedResult.message}")
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
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(R.string.most_visited_products),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText
        )

        LazyHorizontalGrid(
            rows = GridCells.Fixed(3),
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.medium)
                .height(250.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {


            itemsIndexed(mostVisitedList) { index, item ->
                ProductHorizontalCard(
                    name = item.name,
                    id = digitByLocate((index + 1).toString()),
                    imageUrl = item.image
                )
            }
        }
    }

}