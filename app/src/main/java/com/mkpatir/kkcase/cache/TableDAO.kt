package com.mkpatir.kkcase.cache

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mkpatir.kkcase.cache.models.TableModel

@Dao
interface TableDAO {

    @Query("SELECT * FROM `table-name`")
    fun getFavorites(): List<TableModel>

    @Insert
    fun addToFavorites(favoritesModel: TableModel)

    @Delete
    fun removeFromFavorites(favoritesModel: TableModel)

}