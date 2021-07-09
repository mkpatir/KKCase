package com.mkpatir.kkcase.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mkpatir.kkcase.cache.models.TableModel

@Database(entities = [TableModel::class],version = 1)
abstract class DBManager: RoomDatabase() {

    abstract fun favoritesDAO(): TableDAO

    companion object {

        private var instance: DBManager? = null

        fun getOrCreateDBManager(context: Context): DBManager? {
            instance?.let {
                return instance
            } ?: run {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    DBManager::class.java,
                    "favorites-database"
                ).allowMainThreadQueries().build()
                return instance
            }
        }
    }
}