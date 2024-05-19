package com.d121211069.submissionandroidexpert

import android.app.Application
import com.d121211069.submissionandroidexpert.core.di.databaseModule
import com.d121211069.submissionandroidexpert.core.di.networkModule
import com.d121211069.submissionandroidexpert.core.di.repositoryModule
import com.d121211069.submissionandroidexpert.di.useCaseModule
import com.d121211069.submissionandroidexpert.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                )
            )
        }
    }
}