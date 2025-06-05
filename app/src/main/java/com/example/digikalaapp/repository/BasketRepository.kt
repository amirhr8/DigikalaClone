package com.example.digikalaapp.repository


import com.example.digikalaapp.data.db.CartDao
import com.example.digikalaapp.data.model.basket.CartItem
import com.example.digikalaapp.data.model.basket.CartStatus
import com.example.digikalaapp.data.model.home.StoreProduct
import com.example.digikalaapp.data.remote.BaseApiResponse
import com.example.digikalaapp.data.remote.BasketApiInterface
import com.example.digikalaapp.data.remote.NetworkResult
import javax.inject.Inject

class BasketRepository @Inject constructor(
    private val api: BasketApiInterface,
    private val dao: CartDao
) :
    BaseApiResponse() {
    val currentCartItem = dao.getAllItems(CartStatus.CURRENT_CART)
    suspend fun getSuggestedItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getSuggestedItems()
        }

    suspend fun insertCartItem(cart: CartItem) {
        dao.insertCartItem(cart)
    }

}
