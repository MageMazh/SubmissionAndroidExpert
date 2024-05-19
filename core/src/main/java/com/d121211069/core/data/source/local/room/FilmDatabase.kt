package com.d121211069.submissionandroidexpert.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.d121211069.submissionandroidexpert.core.data.source.local.entity.FilmEntity

@Database(
    entities = [FilmEntity::class],
    version = 3,
    exportSchema = false
)
abstract class FilmDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao

}

