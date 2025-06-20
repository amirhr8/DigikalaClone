package com.example.digikalaapp.ui.screens.category

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikalaapp.R
import com.example.digikalaapp.data.model.category.Sub
import com.example.digikalaapp.data.model.home.AmazingItem
import com.example.digikalaapp.data.remote.NetworkResult
import com.example.digikalaapp.ui.components.OurLoading
import com.example.digikalaapp.viewmodel.CategoryViewModel

@Composable
fun SubCategorySection(
    viewModel: CategoryViewModel = hiltViewModel()
) {

    var toolList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var digitalList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var mobileList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var supermarketList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var fashionList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var nativeList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var toyList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var beautyList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var homeList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var bookList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var sportList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val subCategoryResult by viewModel.subCategory.collectAsState()
    when (subCategoryResult) {
        is NetworkResult.Success -> {
            subCategoryResult.data?.let {
                toolList = it.tool
                digitalList = it.digital
                mobileList = it.mobile
                supermarketList = it.supermarket
                fashionList = it.fashion
                nativeList = it.native
                toyList = it.toy
                beautyList = it.beauty
                homeList = it.home
                bookList = it.book
                sportList = it.sport
            }

            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "AmazingItemResult Error:  ${subCategoryResult.message}")
        }

        is NetworkResult.Loading -> {
            loading = true
        }

    }
    if (loading) {
        val config = LocalConfiguration.current
        OurLoading(config.screenHeightDp.dp, true)
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            CategoryItem(
                stringResource(id = R.string.industrial_tools_and_equipment),
                toolList
            )
            CategoryItem(
                title = stringResource(id = R.string.digital_goods),
                subList = digitalList
            )
            CategoryItem(
                title = stringResource(id = R.string.mobile),
                subList = mobileList
            )
            CategoryItem(
                title = stringResource(id = R.string.fashion_and_clothing),
                subList = fashionList
            )
            CategoryItem(
                title = stringResource(id = R.string.supermarket_product),
                subList = supermarketList
            )
            CategoryItem(
                title = stringResource(id = R.string.native_and_local_products),
                subList = nativeList
            )
            CategoryItem(
                title = stringResource(id = R.string.toys_children_and_babies),
                subList = toyList
            )
            CategoryItem(
                title = stringResource(id = R.string.beauty_and_health),
                subList = beautyList
            )
            CategoryItem(
                title = stringResource(id = R.string.home_and_kitchen),
                subList = homeList
            )
            CategoryItem(
                title = stringResource(id = R.string.books_and_stationery),
                subList = bookList
            )
            CategoryItem(
                title = stringResource(id = R.string.sports_and_travel),
                subList = sportList
            )
        }
    }


}
