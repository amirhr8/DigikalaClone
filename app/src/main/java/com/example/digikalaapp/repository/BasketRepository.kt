package com.example.digikalaapp.repository


import com.example.digikalaapp.data.db.CartDao
import com.example.digikalaapp.data.model.basket.CartItem
import com.example.digikalaapp.data.model.category.SubCategory
import com.example.digikalaapp.data.model.home.StoreProduct
import com.example.digikalaapp.data.remote.BaseApiResponse
import com.example.digikalaapp.data.remote.BasketApiInterface
import com.example.digikalaapp.data.remote.CategoryApiInterface
import com.example.digikalaapp.data.remote.NetworkResult
import javax.inject.Inject

class BasketRepository @Inject constructor(
    private val api: BasketApiInterface,
    private val dao: CartDao
) :
    BaseApiResponse() {

    suspend fun getSuggestedItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getSuggestedItems()
        }

    suspend fun insertCartItem(cart: CartItem) {
        dao.insertCartItem(cart)
    }

}
