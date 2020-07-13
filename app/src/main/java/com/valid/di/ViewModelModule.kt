package com.valid.di

import androidx.lifecycle.ViewModel
import com.valid.ui.component.DetailsViewModel
import com.valid.ui.component.main.RecipesListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RecipesListViewModel::class)
    abstract fun bindUserViewModel(viewModel: RecipesListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    internal abstract fun bindSplashViewModel(viewModel: DetailsViewModel): ViewModel
}
