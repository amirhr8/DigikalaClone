package com.example.digikalaapp.data.remote

import com.example.digikalaapp.data.model.ResponseResult
import com.example.digikalaapp.data.model.home.AmazingItem
import com.example.digikalaapp.data.model.home.MainCategory
import com.example.digikalaapp.data.model.home.Slider
import com.example.digikalaapp.data.model.home.StoreProduct
import retrofit2.Response
import retrofit2.http.GET

interface HomeApiInterface {


    @GET("v1/getSlider")
    suspend fun getSlider(): Response<ResponseResult<List<Slider>>>

    @GET("v1/getAmazingProducts")
    suspend fun getAmazingItems(): Response<ResponseResult<List<AmazingItem>>>

    @GET("v1/getSuperMarketAmazingProducts")
    suspend fun getAmazingSuperMarketItems(): Response<ResponseResult<List<AmazingItem>>>

    @GET("v1/get4Banners")
    suspend fun getProposalBanners(): Response<ResponseResult<List<Slider>>>

    @GET("v1/getCategories")
    suspend fun getCategories(): Response<ResponseResult<List<MainCategory>>>

    @GET("v1/getCenterBanners")
    suspend fun getCenterBanner(): Response<ResponseResult<List<Slider>>>


    @GET("v1/getBestsellerProducts")
    suspend fun getBestSellerItems(): Response<ResponseResult<List<StoreProduct>>>

    @GET("v1/getMostVisitedProducts")
    suspend fun getMostVisitedItems(): Response<ResponseResult<List<StoreProduct>>>


    @GET("v1/getMostFavoriteProducts")
    suspend fun getMostFavoriteItems(): Response<ResponseResult<List<StoreProduct>>>

    @GET("v1/getMostDiscountedProducts")
    suspend fun getMostDiscountedItems(): Response<ResponseResult<List<StoreProduct>>>
}