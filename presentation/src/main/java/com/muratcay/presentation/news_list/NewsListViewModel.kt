package com.muratcay.presentation.news_list

import com.muratcay.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor() : BaseViewModel<NewsListState>() {

    override fun setInitialState(): NewsListState {
        TODO("Not yet implemented")
    }
}