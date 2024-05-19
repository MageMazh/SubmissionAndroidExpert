package com.d121211069.submissionandroidexpert.core.domain.usecase

import com.d121211069.submissionandroidexpert.core.data.Resource
import com.d121211069.submissionandroidexpert.core.domain.model.Film
import kotlinx.coroutines.flow.Flow

interface FilmUseCase {
    fun getAllFilm(): Flow<Resource<List<Film>>>

    fun getFavoriteFilm(): Flow<List<Film>>

    fun setFavoriteFilm(film: Film, state: Boolean)

    fun getSearchResult(q: String): Flow<Resource<List<Film>>>
}