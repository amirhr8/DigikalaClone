package com.example.digikalaapp.data.remote

import com.example.digikalaapp.data.model.ResponseResult
import com.example.digikalaapp.data.model.category.SubCategory
import com.example.digikalaapp.data.model.home.StoreProduct
import retrofit2.Response
import retrofit2.http.GET

interface BasketApiInterface {

    @GET("v1/getAllProducts")
    suspend fun getSuggestedItems(): Response<ResponseResult<List<StoreProduct>>>


}