package com.example.digikalaapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digikalaapp.data.model.basket.CartItem
import com.example.digikalaapp.data.model.basket.CartStatus
import com.example.digikalaapp.data.model.home.StoreProduct
import com.example.digikalaapp.data.remote.NetworkResult
import com.example.digikalaapp.repository.BasketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(private val repository: BasketRepository) :
    ViewModel() {

    val suggestedList = MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())

    val currentCartItems: Flow<List<CartItem>> = repository.currentCartItem


    fun getSuggestedItems() {
        viewModelScope.launch {
            suggestedList.emit(repository.getSuggestedItems())
        }
    }

    fun insertCartItem(item: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCartItem(item)
        }
    }

    fun removeCartItem(item: CartItem) {
        viewModelScope.launch {
            repository.removeFromCart(item)
        }
    }

    fun changeCartItemCount(id: String, newCount: Int) {
        viewModelScope.launch {
            repository.changeCartItemCount(id, newCount)
        }
    }

    fun changeCartItemStatus(id: String, newStatus: CartStatus) {
        viewModelScope.launch {
            repository.changeCartItemStatus(id, newStatus)
        }
    }


}

