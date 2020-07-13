package com.valid.ui.component.main

import androidx.recyclerview.widget.RecyclerView
import com.valid.data.dto.ArtistItem
import com.valid.databinding.RecipesitemBinding

class ReceipeViewHolder(private val itemBinding: RecipesitemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(newsItem: ArtistItem, recyclerItemListener: RecyclerItemListener) {
        itemBinding.title.text = newsItem.name

        //itemBinding.rlNewsItem.setOnClickListener { recyclerItemListener.onItemSelected(newsItem) }
    }
}
