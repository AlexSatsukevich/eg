package com.asat.egr.ui.uimodels

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.asat.egr.BR

class GrammarSection(
    name: String) : BaseObservable(){

    @get:Bindable
    var name : String = name
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }
}

