package com.muratcay.database.mapper

import com.muratcay.data.models.SourceEntity
import com.muratcay.database.models.SourceCacheEntity
import javax.inject.Inject

class SourceCacheMapper @Inject constructor() : CacheMapper<SourceCacheEntity, SourceEntity> {
    override fun mapFromCached(type: SourceCacheEntity): SourceEntity {
        return SourceEntity(
            id = type.id,
            name = type.name
        )
    }

    override fun mapToCached(type: SourceEntity): SourceCacheEntity {
        return SourceCacheEntity(
            id = type.id,
            name = type.name
        )
    }
}