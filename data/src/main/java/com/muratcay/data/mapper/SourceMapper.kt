package com.muratcay.data.mapper

import com.muratcay.data.models.SourceEntity
import com.muratcay.domain.models.Source
import javax.inject.Inject

class SourceMapper @Inject constructor() : Mapper<SourceEntity, Source> {
    override fun mapFromEntity(type: SourceEntity): Source {
        return Source(type.id, type.name)
    }

    override fun mapToEntity(type: Source): SourceEntity {
        return SourceEntity(type.id, type.name)
    }
}