package com.asat.egr.data

import com.asat.egr.ui.uimodels.GrammarSection
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class GrammarSectionRepository @Inject constructor() {

    fun getSections(): Observable<ArrayList<GrammarSection>> {

        var arrayList = ArrayList<GrammarSection>()

        arrayList.add(GrammarSection("First grammar section"))
        arrayList.add(GrammarSection("Second grammar section"))
        arrayList.add(GrammarSection("Third grammar section"))

        return Observable.just(arrayList).delay(2, TimeUnit.SECONDS)
    }
}