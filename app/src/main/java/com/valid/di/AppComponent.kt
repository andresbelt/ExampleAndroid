package com.valid.di

import com.valid.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        DataModule::class,
        ErrorModule::class,
        DatabaseModule::class,
        ActivityModuleBuilder::class,
        FragmentModuleBuilder::class
        , ViewModelModule::class
    ]
)
interface AppComponent {
    fun inject(app: App)
}
