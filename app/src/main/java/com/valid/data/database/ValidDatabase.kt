package com.valid.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.valid.data.dto.ResponseGetTopTracks
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = [TemporaryContactNumber::class], version = 1, exportSchema = false)
abstract class ValidDatabase : RoomDatabase() {

    abstract fun ValidDao(): TemporaryContactNumberDAO


    companion object {
        private const val NUMBER_OF_THREADS = 4
        val databaseWriteExecutor: ExecutorService =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS)

        @Volatile
        private var INSTANCE: ValidDatabase? = null

        fun getInstance(context: Context): ValidDatabase =
            INSTANCE
                ?: synchronized(this) {
                    INSTANCE
                        ?: buildDatabase(
                            context
                        )
                            .also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, ValidDatabase::class.java, "valdi_db")
                .fallbackToDestructiveMigration()
                .build()
    }
}