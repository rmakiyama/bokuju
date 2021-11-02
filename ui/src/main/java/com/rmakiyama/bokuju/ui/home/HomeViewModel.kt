package com.rmakiyama.bokuju.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmakiyama.bokuju.usecase.product.GetProductList
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductList: GetProductList,
) : ViewModel() {

    val productList = flow {
        emit(getProductList(Unit))
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
}
