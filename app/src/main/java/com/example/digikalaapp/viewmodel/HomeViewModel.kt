package com.example.digikalaapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digikalaapp.data.model.home.AmazingItem
import com.example.digikalaapp.data.model.home.MainCategory
import com.example.digikalaapp.data.model.home.Slider
import com.example.digikalaapp.data.model.home.StoreProduct
import com.example.digikalaapp.data.remote.NetworkResult
import com.example.digikalaapp.repository.Homerepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Homerepository) : ViewModel() {

    val slider = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val amazingItem = MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())
    val supermarketAmazingItem =
        MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())
    val banners = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val categories = MutableStateFlow<NetworkResult<List<MainCategory>>>(NetworkResult.Loading())
    val centerBannerItem = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val bestSellerItem =
        MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())
    val mostVisitedItem =
        MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())

    val mostFavoriteItem =
        MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())

    val mostDiscountedItem =
        MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())


    suspend fun getAllDataFromServer() {
        viewModelScope.launch {

            // Fire And Forget
            launch {
                slider.emit(repository.getSlider())
            }
            launch {
                amazingItem.emit(repository.getAmzingItems())
            }

            launch {
                supermarketAmazingItem.emit(repository.getAmazingSuperMarketItems())
            }

            launch {
                banners.emit(repository.getProposalBanners())
            }

            launch {
                categories.emit(repository.getCategories())
            }

            launch {
                centerBannerItem.emit(repository.getCenterBanner())
            }

            launch {
                bestSellerItem.emit(repository.getMostVisitedItems())
            }


            launch {
                mostVisitedItem.emit(repository.getBestSellerItems())
            }

            launch {
                mostFavoriteItem.emit(repository.getMostFavoriteItems())
            }
            launch {
                mostDiscountedItem.emit(repository.getMostDiscountedItems())
            }


        }
    }

}


//    suspend fun getSlider() {
//        viewModelScope.launch {
//            slider.emit(repository.getSlider())
//        }
//    }
//
//    suspend fun getAmazing(){
//        viewModelScope.launch {
//            amazingItem.emit(repository.getAmzingItems())
//        }
//    }