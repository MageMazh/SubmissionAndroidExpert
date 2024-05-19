package com.d121211069.submissionandroidexpert.core.data.source.local

import com.d121211069.submissionandroidexpert.core.data.source.local.entity.FilmEntity
import com.d121211069.submissionandroidexpert.core.data.source.local.room.FilmDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val filmDao: FilmDao) {

    fun getAllFilm(): Flow<List<FilmEntity>> = filmDao.getAllFilm()

    fun getFavoriteFilm(): Flow<List<FilmEntity>> = filmDao.getFavoriteFilm()

    suspend fun insertListFilms(filmList: List<FilmEntity>) = filmDao.insertListFilms(filmList)

    fun setFavoriteFilm(film: FilmEntity, newState: Boolean) {
        film.isFavorite = newState
        filmDao.insertFilm(film)
    }
}