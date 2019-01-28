package com.asat.egr.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.asat.egr.R

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

    fun showSection(sectionId:Int){
        val fragment = SectionDetailsFragment.newInstance(sectionId)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment, SectionDetailsFragment::class.java.simpleName)
            .addToBackStack(null)
            .commit()
    }
}
