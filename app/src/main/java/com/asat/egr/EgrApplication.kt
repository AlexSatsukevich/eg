package com.asat.egr

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class EgrApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}