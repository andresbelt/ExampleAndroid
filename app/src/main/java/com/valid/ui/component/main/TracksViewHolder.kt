package com.valid.ui.component.main

import androidx.recyclerview.widget.RecyclerView
import com.valid.data.dto.Artist
import com.valid.data.dto.ArtistItem
import com.valid.data.dto.TrackItem
import com.valid.databinding.RecipesitemBinding

class TracksViewHolder(private val itemBinding: RecipesitemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(newsItem: TrackItem, recyclerItemListener: RecyclerItemListener) {
        itemBinding.title.text = newsItem.name

        //itemBinding.rlNewsItem.setOnClickListener { recyclerItemListener.onItemSelected(newsItem) }
    }
}
