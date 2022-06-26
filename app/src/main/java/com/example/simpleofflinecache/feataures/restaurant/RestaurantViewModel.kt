package com.example.simpleofflinecache.feataures.restaurant

import androidx.lifecycle.*
import com.example.simpleofflinecache.api.RestaurantApi
import com.example.simpleofflinecache.data.Restaurant
import com.example.simpleofflinecache.util.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.CacheResponse
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    repository: RestaurantRepository
) : ViewModel() {
    val restaurants = repository.getRestaurants().asLiveData()

//    private val restaurantsLiveData = MutableLiveData<List<Restaurant>>()
//    val restaurant : LiveData<List<Restaurant>> = restaurantsLiveData
//    init {
//        viewModelScope.launch {
//            val restaurants = api.getRestaurant()
//            delay(2000)
//            restaurantsLiveData.value = restaurants
//        }
//    }
}