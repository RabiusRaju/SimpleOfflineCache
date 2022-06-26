package com.example.simpleofflinecache.util

import androidx.room.withTransaction
import com.example.simpleofflinecache.api.RestaurantApi
import com.example.simpleofflinecache.data.RestaurantDatabase
import kotlinx.coroutines.delay
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val api : RestaurantApi,
    private val db  : RestaurantDatabase
) {

    private val restaurantDao = db.restaurantDao()

    fun getRestaurants()= networkBoundResource(
        query = {
            restaurantDao.getAllRestaurants()
        },
        fetch = {
            delay(2000)
            api.getRestaurant()
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                restaurantDao.deleteAllRestaurants()
                restaurantDao.insertRestaurants(restaurants)
            }

        }
    )
}