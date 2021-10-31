package com.rmakiyama.bokuju.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmakiyama.bokuju.model.Product
import com.rmakiyama.bokuju.usecase.product.GetProductList
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getProductList: GetProductList,
) : ViewModel() {

    val productList = flow {
        emit(getProductList(Unit))
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
}
