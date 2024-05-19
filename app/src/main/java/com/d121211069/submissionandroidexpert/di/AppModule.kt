package com.d121211069.submissionandroidexpert.di

import com.d121211069.submissionandroidexpert.core.domain.usecase.FilmInteractor
import com.d121211069.submissionandroidexpert.core.domain.usecase.FilmUseCase
import com.d121211069.submissionandroidexpert.ui.home.HomeViewModel
import com.d121211069.submissionandroidexpert.ui.search.SearchViewModel
import com.d121211069.submissionandroidexpert.ui.detail.DetailViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val useCaseModule = module {
    factory<FilmUseCase> { FilmInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}