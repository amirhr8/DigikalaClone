package com.example.digikalaapp.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikalaapp.data.model.home.Slider
import com.example.digikalaapp.viewmodel.HomeViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.example.digikalaapp.data.remote.NetworkResult
import com.example.digikalaapp.ui.components.OurLoading
import com.example.digikalaapp.ui.theme.LocalShape
import com.example.digikalaapp.ui.theme.LocalSpacing
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TopSliderSection(
    viewModel: HomeViewModel = hiltViewModel()
) {

    var sliderList by remember {
        mutableStateOf<List<Slider>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val sliderResult by viewModel.slider.collectAsState()
    when (sliderResult) {
        is NetworkResult.Success -> {
//                    sliderResult.data?.let {
//                        sliderList = it
//                        Log.e("3636", "image : ${sliderList[0].image}" )
//                    }

            sliderList = sliderResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "Top Slider Error:  ${sliderResult.message}")

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
                .height(200.dp)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .height(200.dp)
                    .background(Color.White)
                    .padding(
                        horizontal = LocalSpacing.current.extraSmall,
                        vertical = LocalSpacing.current.extraSmall
                    )
            ) {
                val pagerState = rememberPagerState()
                var imageUrl by remember {
                    mutableStateOf("")
                }
                HorizontalPager(
                    count = sliderList.size,
                    state = pagerState,
                    contentPadding = PaddingValues(horizontal = LocalSpacing.current.medium),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()

                ) { index ->
                    imageUrl = sliderList[index].image
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        val painter = rememberAsyncImagePainter(
                            ImageRequest.Builder(LocalContext.current)
                                .data(data = imageUrl)
                                .apply(
                                    block = fun ImageRequest.Builder.() {
                                        scale(Scale.FIT)
                                    }
                                ).build()
                        )
                        Image(
                            painter, contentDescription = "", modifier = Modifier
                                .padding(LocalSpacing.current.small)
                                .clip(LocalShape.current.medium)
                                .fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )

                        HorizontalPagerIndicator(
                            pagerState = pagerState,
                            modifier = Modifier
                                .padding(start = 12.dp, bottom = 12.dp)
                                .align(Alignment.BottomEnd),
                            activeColor = Color.Black,
                            inactiveColor = Color.White,
                            indicatorWidth = LocalSpacing.current.small,
                            indicatorHeight = LocalSpacing.current.small,
                            indicatorShape = CircleShape
                        )

                    }

                }

                LaunchedEffect(key1 = pagerState.currentPage) {
                    delay(3000)
                    var newPosition = pagerState.currentPage + 1
                    if (newPosition > sliderList.size - 1) newPosition = 0
                    pagerState.scrollToPage(newPosition)

                }
            }

        }

    }


}
