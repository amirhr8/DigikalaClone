package com.example.digikalaapp.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.decode.ImageSource
import com.example.digikalaapp.R
import com.example.digikalaapp.data.model.home.AmazingItem
import com.example.digikalaapp.data.model.home.MainCategory
import com.example.digikalaapp.data.remote.NetworkResult
import com.example.digikalaapp.ui.theme.darkText
import com.example.digikalaapp.ui.theme.spacing
import com.example.digikalaapp.viewmodel.HomeViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoryListSection(
    viewModel: HomeViewModel = hiltViewModel()
) {
    var categoryList by remember {
        mutableStateOf<List<MainCategory>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val categoryResult by viewModel.categories.collectAsState()
    when (categoryResult) {
        is NetworkResult.Success -> {
            categoryList = categoryResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "Category Error:  ${categoryResult.message}")
        }

        is NetworkResult.Loading -> {
            loading = true
        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.small)
    )
    {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.medium),
            text = stringResource(R.string.category_title),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText
        )


        FlowRow(
            maxItemsInEachRow = 3,
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            for (item in categoryList) {
                CircularCategoryItem(item)
            }
        }

    }
}

@Composable
fun CircularCategoryItem(item: MainCategory) {
    Column(
        modifier = Modifier.size(100.dp, 160.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(item.image),
            contentDescription = "",
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(vertical = MaterialTheme.spacing.extraSmall)
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MaterialTheme.spacing.extraSmall),
            text = item.name,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis

        )


    }
}


