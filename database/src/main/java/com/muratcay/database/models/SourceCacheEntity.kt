package com.muratcay.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.muratcay.database.utils.CacheConstants

@Entity(tableName = CacheConstants.SOURCE_TABLE_NAME)
data class SourceCacheEntity(
    @PrimaryKey
    @ColumnInfo(name = "source_id")
    val id: String,
    @ColumnInfo(name = "source_name") val name: String
)