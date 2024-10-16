package com.muratcay.presentation.article_detail

import com.muratcay.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticleDetailViewModel @Inject constructor() : BaseViewModel<ArticleDetailState>() {

    override fun setInitialState(): ArticleDetailState {
        TODO("Not yet implemented")
    }
}