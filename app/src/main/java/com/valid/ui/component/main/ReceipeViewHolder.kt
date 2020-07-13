package com.valid.ui.component.main

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.valid.R
import com.valid.data.dto.ArtistItem
import com.valid.databinding.RecipesitemBinding
import java.lang.System.load

class ReceipeViewHolder(private val itemBinding: RecipesitemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(newsItem: ArtistItem, recyclerItemListener: RecyclerItemListener) {
        itemBinding.title.text = newsItem.name

        Picasso.get().load(newsItem.image!!.get(0)!!.text).into(itemBinding.image)
        //itemBinding.rlNewsItem.setOnClickListener { recyclerItemListener.onItemSelected(newsItem) }
    }
}
