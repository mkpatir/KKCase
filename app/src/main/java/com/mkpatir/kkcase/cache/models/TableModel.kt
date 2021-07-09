package com.mkpatir.kkcase.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table-name")
data class TableModel(
    @PrimaryKey
    @ColumnInfo(name = "column1")
    var column1: String,
    @ColumnInfo(name = "column2")
    var column2: String
)