package com.muratcay.newsapppoilabs.feature.article_detail_screen

import com.muratcay.newsapppoilabs.R
import com.muratcay.newsapppoilabs.databinding.FragmentArticleDetailBinding
import com.muratcay.presentation.article_detail.ArticleDetailViewModel
import com.muratcay.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleDetailFragment : BaseFragment<FragmentArticleDetailBinding, ArticleDetailViewModel>(R.layout.fragment_article_detail) {

    override fun getViewModelClass(): Class<ArticleDetailViewModel> =
        ArticleDetailViewModel::class.java

    override fun initObserver() {
        TODO("Not yet implemented")
    }

    override fun initViews() {
        TODO("Not yet implemented")
    }

}