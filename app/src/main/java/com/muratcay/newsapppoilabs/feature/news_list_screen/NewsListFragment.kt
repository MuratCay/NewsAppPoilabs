package com.muratcay.newsapppoilabs.feature.news_list_screen

import com.muratcay.newsapppoilabs.R
import com.muratcay.newsapppoilabs.databinding.FragmentNewsListBinding
import com.muratcay.presentation.base.BaseFragment
import com.muratcay.presentation.news_list.NewsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListFragment : BaseFragment<FragmentNewsListBinding, NewsListViewModel>(R.layout.fragment_news_list) {

    override fun getViewModelClass(): Class<NewsListViewModel> = NewsListViewModel::class.java

    override fun initObserver() {
        TODO("Not yet implemented")
    }

    override fun initViews() {
        TODO("Not yet implemented")
    }
}