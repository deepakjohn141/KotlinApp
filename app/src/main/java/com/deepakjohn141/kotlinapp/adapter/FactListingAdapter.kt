package com.deepakjohn141.kotlinapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deepakjohn141.kotlinapp.databinding.FactItemBinding
import com.deepakjohn141.kotlinapp.network.response.Fact

class FactListingAdapter: RecyclerView.Adapter<FactListingAdapter.FactViewHolder>() {

    private val facts = mutableListOf<Fact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactViewHolder {
        val binding = FactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FactViewHolder, position: Int) {
        val fact = facts[position]
        holder.binding.fact = fact
    }

    override fun getItemCount() = facts.size

    fun setData(facts: List<Fact>){
        this.facts.apply {
            clear()
            addAll(facts)
        }
        notifyDataSetChanged()
    }

    inner class FactViewHolder(val binding: FactItemBinding) : RecyclerView.ViewHolder(binding.root)
}