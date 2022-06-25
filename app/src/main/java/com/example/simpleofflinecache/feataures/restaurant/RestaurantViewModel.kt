package com.example.simpleofflinecache.feataures.restaurant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleofflinecache.api.RestaurantApi
import com.example.simpleofflinecache.data.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    api: RestaurantApi
) : ViewModel() {

    private val restaurantsLiveData = MutableLiveData<List<Restaurant>>()
    val restaurant : LiveData<List<Restaurant>> = restaurantsLiveData
    init {
        viewModelScope.launch {
            val restaurants = api.getRestaurant()
            delay(2000)
            restaurantsLiveData.value = restaurants
        }
    }
}