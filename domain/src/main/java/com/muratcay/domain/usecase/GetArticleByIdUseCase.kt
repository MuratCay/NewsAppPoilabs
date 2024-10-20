package com.muratcay.domain.usecase

import com.muratcay.domain.Result
import com.muratcay.domain.models.Article
import com.muratcay.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetArticleByIdBaseUseCase = BaseUseCase<Long, Flow<Result<Article>>>

class GetArticleByIdUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) : GetArticleByIdBaseUseCase {

    override suspend fun invoke(params: Long): Flow<Result<Article>> {
        return newsRepository.getNewsById(params)
    }
}