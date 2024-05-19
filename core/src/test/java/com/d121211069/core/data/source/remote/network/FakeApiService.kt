package com.d121211069.core.data.source.remote.network

import com.d121211069.core.utils.DataDummy
import com.d121211069.submissionandroidexpert.core.data.source.remote.network.ApiService
import com.d121211069.submissionandroidexpert.core.data.source.remote.response.FilmResponse

class FakeApiService : ApiService {
    private val dummyResponse = DataDummy.generateDummyNewsResponse()

    override suspend fun getList(token: String): FilmResponse {
        return dummyResponse
    }

    override suspend fun getSearchMovie(token: String, query: String): FilmResponse {
        return dummyResponse
    }
}