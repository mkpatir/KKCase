package com.mkpatir.kkcase.cache

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mkpatir.kkcase.cache.models.FavoriteModel

@Dao
interface FavoritesDAO {

    @Query("SELECT * FROM `favorites`")
    fun getFavorites(): List<FavoriteModel>

    @Insert
    fun addToFavorites(favoritesModel: FavoriteModel)

    @Delete
    fun removeFromFavorites(favoritesModel: FavoriteModel)

}