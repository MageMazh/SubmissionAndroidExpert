package com.d121211069.submissionandroidexpert.di

import com.d121211069.favorite.FavoriteViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val favoriteModule = module {
    viewModel { FavoriteViewModel(get()) }
}