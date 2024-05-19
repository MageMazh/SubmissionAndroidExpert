package com.d121211069.submissionandroidexpert.core.domain.repository

import com.d121211069.submissionandroidexpert.core.data.Resource
import com.d121211069.submissionandroidexpert.core.domain.model.Film
import kotlinx.coroutines.flow.Flow

interface IFilmRepository {
    fun getAllFilm(): Flow<Resource<List<Film>>>
    fun getAllFavoriteFilm(): Flow<List<Film>>
    fun setFavoriteFilm(film: Film, state: Boolean)
    fun getSearchMovie(q: String): Flow<Resource<List<Film>>>
}