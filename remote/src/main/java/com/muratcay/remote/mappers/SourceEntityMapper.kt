package com.muratcay.remote.mappers

import com.muratcay.data.models.SourceEntity
import com.muratcay.remote.models.Source
import javax.inject.Inject

class SourceEntityMapper @Inject constructor() : EntityMapper<Source, SourceEntity> {
    override fun mapFromModel(model: Source): SourceEntity {
        return SourceEntity(model.id.orEmpty(), model.name.orEmpty())
    }
}