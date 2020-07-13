package com.valid.di

import com.valid.ui.component.DetailsActivity
import com.valid.ui.component.SplashActivity
import com.valid.ui.component.main.MenuActivity
import com.valid.ui.component.main.ArtistsActivity
import com.valid.ui.component.main.TracksActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModuleBuilder {

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): ArtistsActivity

    @ContributesAndroidInjector
    abstract fun contributeMenuActivity(): MenuActivity


    @ContributesAndroidInjector
    abstract fun contributeTracksActivity(): TracksActivity


    @ContributesAndroidInjector
    abstract fun contributeDetailsActivity(): DetailsActivity
}
