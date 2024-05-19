package com.d121211069.submissionandroidexpert.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.d121211069.submissionandroidexpert.core.domain.usecase.FilmUseCase

class HomeViewModel(filmUseCase: FilmUseCase) : ViewModel() {
    val film = filmUseCase.getAllFilm().asLiveData()
}