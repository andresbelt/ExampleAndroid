package com.valid.ui.component.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.valid.data.dto.ArtistItem
import com.valid.data.dto.ResponseGetTop
import com.valid.data.dto.ResponseGetTopTracks

import com.valid.databinding.RecipesitemBinding

class RecipesAdapter(private val newsListViewModel: RecipesListViewModel,
                     private val receipe: List<ArtistItem?>? ) : RecyclerView.Adapter<ReceipeViewHolder>() {

    private val onItemClickListener: RecyclerItemListener = object : RecyclerItemListener {
        override fun onItemSelected(newsItem: ResponseGetTop) {
            newsListViewModel.openRecipesDetails(newsItem)
        }

        override fun onItemSelected(newsItem: ResponseGetTopTracks) {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceipeViewHolder {
        val itemBinding = RecipesitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReceipeViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ReceipeViewHolder, position: Int) {
        holder.bind(receipe?.get(position)!!, onItemClickListener)
    }

    override fun getItemCount(): Int {
        return receipe!!.size
    }
}

