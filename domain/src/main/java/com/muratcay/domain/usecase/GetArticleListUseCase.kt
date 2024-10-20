package com.muratcay.domain.usecase

import com.muratcay.domain.Result
import com.muratcay.domain.models.Article
import com.muratcay.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetArticleListBaseUseCase = BaseUseCase<Unit, Flow<Result<List<Article>>>>

class GetArticleListUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) : GetArticleListBaseUseCase {

    override suspend fun invoke(params: Unit): Flow<Result<List<Article>>> {
        return newsRepository.getNews()
    }
}