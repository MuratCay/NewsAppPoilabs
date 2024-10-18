package com.muratcay.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.muratcay.database.utils.CacheConstants

@Entity(tableName = CacheConstants.SOURCE_TABLE_NAME)
data class SourceCacheEntity(
    @ColumnInfo(name = "source_id") val id: String,
    @ColumnInfo(name = "source_name") val name: String
)