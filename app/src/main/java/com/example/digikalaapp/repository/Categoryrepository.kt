package com.example.digikalaapp.repository


import com.example.digikalaapp.data.model.category.SubCategory
import com.example.digikalaapp.data.remote.BaseApiResponse
import com.example.digikalaapp.data.remote.CategoryApiInterface
import com.example.digikalaapp.data.remote.NetworkResult
import javax.inject.Inject

class Categoryrepository @Inject constructor(private val api: CategoryApiInterface) :
    BaseApiResponse() {


    suspend fun getSubCategories(): NetworkResult<SubCategory> =
        safeApiCall {
            api.getSubCategories()
        }

}
