package com.example.digikalaapp.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.digikalaapp.R
import com.example.digikalaapp.data.model.home.StoreProduct
import com.example.digikalaapp.data.remote.NetworkResult
import com.example.digikalaapp.ui.theme.DarkCyan
import com.example.digikalaapp.ui.theme.darkText
import com.example.digikalaapp.ui.theme.spacing
import com.example.digikalaapp.viewmodel.HomeViewModel
import okhttp3.internal.format

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MostDiscountedSection(
    viewModel: HomeViewModel = hiltViewModel()
) {

    var mostDiscountedList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val mostDiscountedResult by viewModel.mostDiscountedItem.collectAsState()
    when (mostDiscountedResult) {
        is NetworkResult.Success -> {
            mostDiscountedList = mostDiscountedResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "Most Favorite Error:  ${mostDiscountedResult.message}")
        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.small),
            text = stringResource(R.string.most_discounted_products),
            textAlign = TextAlign.Right,
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText
        )

        FlowRow(
            maxItemsInEachRow = 2,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Start
        ) {
            for (item in mostDiscountedList) {
                MostDiscountedCard(item)
            }
        }
    }

}