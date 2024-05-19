package com.d121211069.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.d121211069.submissionandroidexpert.core.domain.usecase.FilmUseCase

class FavoriteViewModel(filmUseCase: FilmUseCase) : ViewModel() {
    val favoriteFilm = filmUseCase.getFavoriteFilm().asLiveData()
}