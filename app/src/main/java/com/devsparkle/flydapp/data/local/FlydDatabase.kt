package com.devsparkle.flydapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.devsparkle.flydapp.data.local.dao.AlbumDao
import com.devsparkle.flydapp.data.local.dao.ArtistDao
import com.devsparkle.flydapp.data.local.entities.AlbumEntity
import com.devsparkle.flydapp.data.local.entities.ArtistEntity
import com.devsparkle.flydapp.data.local.shared.DateConverter
import com.devsparkle.flydapp.data.local.shared.DateToStringConverter

@Database(
    entities = [
        AlbumEntity::class,
        ArtistEntity::class
    ], version = 1, exportSchema = true
)
@TypeConverters(DateConverter::class, DateToStringConverter::class)
abstract class FlydDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
    abstract fun artistDao(): ArtistDao
}
