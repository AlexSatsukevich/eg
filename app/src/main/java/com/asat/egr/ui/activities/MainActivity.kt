package com.asat.egr.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.asat.egr.R
import com.asat.egr.ui.uimodels.GrammarSection

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) return

        val fragment = SectionListFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment, SectionListFragment::class.java.simpleName)
            .commit()
    }

    fun showSection(section:GrammarSection){

    }
}
