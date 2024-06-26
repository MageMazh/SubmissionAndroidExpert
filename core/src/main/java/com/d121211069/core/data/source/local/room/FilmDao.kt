package com.d121211069.submissionandroidexpert.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.d121211069.submissionandroidexpert.core.data.source.local.entity.FilmEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {

    @Query("SELECT * FROM film")
    fun getAllFilm(): Flow<List<FilmEntity>>

    @Query("SELECT * FROM film where isFavorite = 1")
    fun getFavoriteFilm(): Flow<List<FilmEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListFilms(film: List<FilmEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilm(film: FilmEntity)

}