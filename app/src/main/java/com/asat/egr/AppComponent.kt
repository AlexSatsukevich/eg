package com.asat.egr

import com.asat.egr.ui.activities.SectionListFragmentModule
import com.asat.egr.utility.di.ViewModelBuilder
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        ViewModelBuilder::class,
        SectionListFragmentModule::class])

interface AppComponent : AndroidInjector<EgrApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<EgrApplication>()
}