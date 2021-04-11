package com.example.itunes.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.itunes.data.ItuneDto
import com.example.itunes.util.AppConstants

@Database(entities = [ItuneDto::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun videoItemDao(): VideoItemDao

    companion object {

        // For doing any changes on database we have to create migrations file
//        private val MIGRATION_1_2  = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("")
//            }
//        }

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        AppConstants.APP_DATABASE_NAME)
//                            .addMigrations(MIGRATION_1_2) // If we want to migrate
                        .fallbackToDestructiveMigration() // if we don't want to provide migration
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}