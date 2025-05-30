package com.example.digikalaapp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikalaapp.util.Constants.USER_LANGUAGE
import com.example.digikalaapp.viewmodel.DataStoreViewModel

@Composable
fun AppConfig(
    dataStore: DataStoreViewModel = hiltViewModel()
) {
    LaunchedEffect(true) {
        getDataStoreVariables(dataStore)

    }
}


private suspend fun getDataStoreVariables(dataStore: DataStoreViewModel) {
    USER_LANGUAGE = dataStore.getUserLanguage()
    dataStore.saveUserLanguage(USER_LANGUAGE)
}