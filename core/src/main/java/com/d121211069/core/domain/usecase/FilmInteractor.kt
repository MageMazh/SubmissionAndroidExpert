package com.d121211069.submissionandroidexpert.core.domain.usecase

import com.d121211069.submissionandroidexpert.core.domain.model.Film
import com.d121211069.submissionandroidexpert.core.domain.repository.IFilmRepository

class FilmInteractor(private val filmRepository: IFilmRepository) : FilmUseCase {

    override fun getAllFilm() = filmRepository.getAllFilm()

    override fun getFavoriteFilm() = filmRepository.getAllFavoriteFilm()

    override fun setFavoriteFilm(film: Film, state: Boolean) =
        filmRepository.setFavoriteFilm(film, state)

    override fun getSearchResult(q: String) = filmRepository.getSearchMovie(q)

}