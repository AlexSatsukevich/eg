package com.asat.egr.ui.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asat.egr.R
import com.asat.egr.databinding.FragmentSectionListBinding
import com.asat.egr.ui.adapters.SectionRecyclerViewAdapter
import com.asat.egr.ui.uimodels.GrammarSection
import com.asat.egr.ui.viewmodels.MainViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SectionListFragment : Fragment(), SectionRecyclerViewAdapter.OnItemClickListener {

    private lateinit var binding: FragmentSectionListBinding
    private val repositoryRecyclerViewAdapter = SectionRecyclerViewAdapter(arrayListOf(), this)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_section_list, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val mainActivity = activity

        val viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MainViewModel::class.java)

        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.sectionsRv.layoutManager = LinearLayoutManager(mainActivity)
        binding.sectionsRv.adapter = repositoryRecyclerViewAdapter
        viewModel.sections.observe(this,
            Observer<ArrayList<GrammarSection>> { it -> it?.let { repositoryRecyclerViewAdapter.replaceData(it) } })

        viewModel.loadSections()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onItemClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}