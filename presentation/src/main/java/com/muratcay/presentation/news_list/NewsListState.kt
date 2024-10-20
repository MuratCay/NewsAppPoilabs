package com.muratcay.presentation.news_list

import com.muratcay.domain.models.Article
import com.muratcay.presentation.base.IState

sealed interface NewsListState : IState {
    data object Loading : NewsListState
    data class Success(val article: List<Article>?) : NewsListState
    data class Error(val error: Exception) : NewsListState
}