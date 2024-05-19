package com.d121211069.submissionandroidexpert.ui.detail

import androidx.lifecycle.ViewModel
import com.d121211069.submissionandroidexpert.core.domain.model.Film
import com.d121211069.submissionandroidexpert.core.domain.usecase.FilmUseCase

class DetailViewModel(private val filmUseCase: FilmUseCase) : ViewModel() {
    fun setFavoriteFilm(film: Film, newStatus: Boolean) =
        filmUseCase.setFavoriteFilm(film, newStatus)
}