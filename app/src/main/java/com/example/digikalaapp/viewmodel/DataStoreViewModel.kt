package com.example.digikalaapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digikalaapp.data.datastore.DataStoreRepository
import com.example.digikalaapp.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel(){

    companion object{
        const val USER_LANGUAGE_KEY = "USER_LANGUAGE_KEY"
    }

    fun saveUserLanguage (value: String){
        viewModelScope.launch {
            repository.putString(USER_LANGUAGE_KEY,value)
        }
    }


    fun getUserLanguage() :String = runBlocking {
        repository.getString(USER_LANGUAGE_KEY) ?: Constants.PERSIAN_LANG
    }

}