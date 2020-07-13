package com.valid.di

import com.valid.data.DataRepository
import com.valid.data.server.Source
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideDataRepository(dataRepository: DataRepository): Source
}
