package com.asat.egr.ui.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asat.egr.R

class SectionDetailsFragment : Fragment() {
    companion object {
        fun newInstance(sectionId: Int): SectionDetailsFragment {
            val fragment = SectionDetailsFragment()
            val args = Bundle()
            args.putInt("sectionId", sectionId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val sectionId = arguments?.getInt("sectionId")

        return inflater?.inflate(R.layout.fragment_section_details, container, false)
    }
}