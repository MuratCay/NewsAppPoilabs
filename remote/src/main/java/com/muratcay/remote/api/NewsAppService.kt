package com.muratcay.remote.api

import com.muratcay.remote.models.NewsResponse
import com.muratcay.remote.utils.RemoteConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAppService {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "tr",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = RemoteConstants.apiKey
    ): NewsResponse
}