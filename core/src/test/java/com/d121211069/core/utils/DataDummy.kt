package com.d121211069.core.utils

import com.d121211069.submissionandroidexpert.core.data.source.remote.response.FilmResponse
import com.d121211069.submissionandroidexpert.core.data.source.remote.response.ResultsItem

object DataDummy {

    fun generateDummyNewsResponse(): FilmResponse {
        val newsList = ArrayList<ResultsItem>()
        for (i in 0..10) {
            val news = ResultsItem(
                "description",
                "author $i",
                "title $i",
                false,
                "description $i",
                null,
                "image",
                "image",
                "2022-02-22T22:22:22Z",
                "900",
                95.0,
                "id $i",
            )
            newsList.add(news)
        }
        return FilmResponse(1, 1, newsList, newsList.size)
    }
}