package com.asat.egr.ui.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import com.asat.egr.data.GrammarSectionRepository
import com.asat.egr.ui.uimodels.GrammarSection
import com.asat.egr.utility.extensions.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(var sectionRepository: GrammarSectionRepository) : ViewModel() {

    val isLoading = ObservableBoolean (false)

    var sections = MutableLiveData<ArrayList<GrammarSection>>()

    private val compositeDisposable = CompositeDisposable()

    fun loadSections() {
        isLoading.set(true)
        compositeDisposable += sectionRepository
            .getSections()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ArrayList<GrammarSection>>() {

                override fun onError(e: Throwable) {
                    //if some error happens in our data layer our app will not crash, we will
                    // get error here
                }

                override fun onNext(data: ArrayList<GrammarSection>) {
                    sections.value = data
                }

                override fun onComplete() {
                    isLoading.set(false)
                }
            })
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}