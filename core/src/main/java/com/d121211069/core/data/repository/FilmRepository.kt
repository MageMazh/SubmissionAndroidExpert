package com.d121211069.submissionandroidexpert.core.data.repository

import com.d121211069.submissionandrofilmIdexpert.core.utils.DataMapper
import com.d121211069.submissionandroidexpert.core.data.NetworkBoundResource
import com.d121211069.submissionandroidexpert.core.data.Resource
import com.d121211069.submissionandroidexpert.core.data.source.local.LocalDataSource
import com.d121211069.submissionandroidexpert.core.data.source.remote.RemoteDataSource
import com.d121211069.submissionandroidexpert.core.data.source.remote.network.ApiResponse
import com.d121211069.submissionandroidexpert.core.data.source.remote.response.ResultsItem
import com.d121211069.submissionandroidexpert.core.domain.model.Film
import com.d121211069.submissionandroidexpert.core.domain.repository.IFilmRepository
import com.d121211069.submissionandroidexpert.core.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FilmRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IFilmRepository {

    override fun getAllFilm(): Flow<Resource<List<Film>>> =
        object : NetworkBoundResource<List<Film>, List<ResultsItem>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Film>> {
                return localDataSource.getAllFilm().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Film>?): Boolean = data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<ResultsItem>>> =
                remoteDataSource.getAllPopularMovie()

            override suspend fun saveCallResult(data: List<ResultsItem>) {
                val FilmList = DataMapper.mapResponsesToEntities(data)

                localDataSource.insertListFilms(FilmList)
            }
        }.asFlow()

    override fun getSearchMovie(q: String): Flow<Resource<List<Film>>> =
        remoteDataSource.searchMovie(q)

    override fun getAllFavoriteFilm(): Flow<List<Film>> {
        return localDataSource.getFavoriteFilm().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteFilm(film: Film, state: Boolean) {
        val filmEntity = DataMapper.mapDomainToEntity(film)
        appExecutors.diskIO().execute { localDataSource.setFavoriteFilm(filmEntity, state) }
    }
}