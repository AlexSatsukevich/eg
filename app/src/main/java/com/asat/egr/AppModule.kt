package com.asat.egr

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun providesContext(application: EgrApplication): Context {
        return application.applicationContext
    }
}