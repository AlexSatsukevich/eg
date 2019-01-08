package com.asat.egr.ui.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.asat.egr.R
import com.asat.egr.databinding.ActivityMainBinding
import com.asat.egr.ui.adapters.SectionRecyclerViewAdapter
import com.asat.egr.ui.uimodels.GrammarSection
import com.asat.egr.ui.viewmodels.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), SectionRecyclerViewAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val repositoryRecyclerViewAdapter = SectionRecyclerViewAdapter(arrayListOf(), this)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MainViewModel::class.java)

        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.sectionsRv.layoutManager = LinearLayoutManager(this)
        binding.sectionsRv.adapter = repositoryRecyclerViewAdapter
        viewModel.sections.observe(this,
            Observer<ArrayList<GrammarSection>> { it -> it?.let { repositoryRecyclerViewAdapter.replaceData(it) } })

        viewModel.loadSections()
    }

    override fun onItemClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
