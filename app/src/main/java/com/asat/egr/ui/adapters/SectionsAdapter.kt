package com.asat.egr.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.asat.egr.ui.uimodels.GrammarSection
import com.asat.egr.databinding.RvItemGrammarSectionBinding

class SectionRecyclerViewAdapter(private var items: ArrayList<GrammarSection>,
                                    private var listener: OnItemClickListener)
    : RecyclerView.Adapter<SectionRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvItemGrammarSectionBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(items[position], listener)

    override fun getItemCount(): Int = items.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun replaceData(arrayList: ArrayList<GrammarSection>) {
        items = arrayList
        notifyDataSetChanged()
    }

    class ViewHolder(private var binding: RvItemGrammarSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(section: GrammarSection, listener: OnItemClickListener?) {
            binding.section = section
            if (listener != null) {
                binding.root.setOnClickListener { listener.onItemClick(layoutPosition) }
            }

            binding.executePendingBindings()
        }
    }
}