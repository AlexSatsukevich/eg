package com.asat.egr.ui.activities

import android.arch.lifecycle.ViewModel
import com.asat.egr.ui.viewmodels.MainViewModel
import com.asat.egr.utility.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class SectionListFragmentModule {

    @ContributesAndroidInjector
    internal abstract fun sectionListFragment(): SectionListFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}