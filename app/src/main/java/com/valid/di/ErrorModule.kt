package com.valid.di

import com.valid.bussinesLogic.errors.ErrorFactory
import com.valid.bussinesLogic.errors.ErrorManager
import com.valid.data.errors.ErrorMapper
import com.valid.data.errors.ErrorMapperInterface
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ErrorModule {
    @Binds
    @Singleton
    abstract fun provideErrorFactoryImpl(errorManager: ErrorManager): ErrorFactory

    @Binds
    @Singleton
    abstract fun provideErrorMapper(errorMapper: ErrorMapper): ErrorMapperInterface
}
