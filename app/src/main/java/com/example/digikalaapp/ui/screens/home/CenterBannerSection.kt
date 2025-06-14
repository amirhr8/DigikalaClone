package com.example.digikalaapp.ui.screens.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikalaapp.data.model.home.Slider
import com.example.digikalaapp.data.remote.NetworkResult
import com.example.digikalaapp.ui.components.CenterBannerItem
import com.example.digikalaapp.viewmodel.HomeViewModel

@Composable
fun CenterBannerSection(
    bannerNumber: Int,
    viewModel: HomeViewModel = hiltViewModel()
) {

    var centerBannerList by remember {
        mutableStateOf<List<Slider>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val centerBannerResult by viewModel.centerBannerItem.collectAsState()
    when (centerBannerResult) {
        is NetworkResult.Success -> {
            centerBannerList = centerBannerResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "Category Error:  ${centerBannerResult.message}")
        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }

    if (centerBannerList.isNotEmpty()) {
        CenterBannerItem(imagUrl = centerBannerList[bannerNumber - 1].image)
    }


}