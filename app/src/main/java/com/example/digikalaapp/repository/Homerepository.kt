package com.example.digikalaapp.repository

import com.example.digikalaapp.data.model.home.AmazingItem
import com.example.digikalaapp.data.model.home.MainCategory
import com.example.digikalaapp.data.model.home.Slider
import com.example.digikalaapp.data.model.home.StoreProduct
import com.example.digikalaapp.data.remote.BaseApiResponse
import com.example.digikalaapp.data.remote.HomeApiInterface
import com.example.digikalaapp.data.remote.NetworkResult
import javax.inject.Inject

class Homerepository @Inject constructor(private val api: HomeApiInterface) : BaseApiResponse() {


    suspend fun getSlider(): NetworkResult<List<Slider>> =
        safeApiCall {
            api.getSlider()
        }


    suspend fun getAmzingItems(): NetworkResult<List<AmazingItem>> =
        safeApiCall {
            api.getAmazingItems()
        }

    suspend fun getAmazingSuperMarketItems(): NetworkResult<List<AmazingItem>> =
        safeApiCall {
            api.getAmazingSuperMarketItems()
        }


    suspend fun getProposalBanners(): NetworkResult<List<Slider>> =
        safeApiCall {
            api.getProposalBanners()
        }

    suspend fun getCategories(): NetworkResult<List<MainCategory>> =
        safeApiCall {
            api.getCategories()
        }

    suspend fun getCenterBanner(): NetworkResult<List<Slider>> =
        safeApiCall {
            api.getCenterBanner()
        }

    suspend fun getBestSellerItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getBestSellerItems()
        }

    suspend fun getMostVisitedItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getMostVisitedItems()
        }

    suspend fun getMostFavoriteItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getMostFavoriteItems()
        }

    suspend fun getMostDiscountedItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getMostDiscountedItems()
        }
}
