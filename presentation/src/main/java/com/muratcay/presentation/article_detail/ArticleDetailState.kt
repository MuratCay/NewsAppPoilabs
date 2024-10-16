package com.muratcay.presentation.article_detail

import com.muratcay.presentation.base.IState

sealed interface ArticleDetailState : IState {
    data object Loading : ArticleDetailState
    data class Error(val error: Exception) : ArticleDetailState
}