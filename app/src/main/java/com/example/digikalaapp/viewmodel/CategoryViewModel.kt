package com.example.digikalaapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digikalaapp.data.model.category.SubCategory
import com.example.digikalaapp.data.model.home.AmazingItem
import com.example.digikalaapp.data.model.home.MainCategory
import com.example.digikalaapp.data.model.home.Slider
import com.example.digikalaapp.data.model.home.StoreProduct
import com.example.digikalaapp.data.remote.NetworkResult
import com.example.digikalaapp.repository.Categoryrepository
import com.example.digikalaapp.repository.Homerepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: Categoryrepository) :
    ViewModel() {

    val subCategory = MutableStateFlow<NetworkResult<SubCategory>>(NetworkResult.Loading())


    suspend fun getAllDataFromServer() {
        viewModelScope.launch {

            // Fire And Forget
            launch {
                subCategory.emit(repository.getSubCategories())
            }

        }
    }

}

