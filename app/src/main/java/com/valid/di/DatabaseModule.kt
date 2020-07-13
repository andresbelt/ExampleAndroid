package com.valid.di

import android.content.Context
import com.valid.data.database.TemporaryContactNumberDAO
import com.valid.data.database.ValidDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun providesAppDb(ctx: Context): ValidDatabase {
        return ValidDatabase.getInstance(ctx)
    }


    @Singleton
    @Provides
    fun providesPecDao(demoDatabase: ValidDatabase): TemporaryContactNumberDAO {
        return demoDatabase.ValidDao()
    }

}
