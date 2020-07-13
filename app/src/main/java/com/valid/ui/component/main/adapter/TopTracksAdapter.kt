package com.valid.ui.component.main.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.valid.data.dto.*

import com.valid.databinding.RecipesitemBinding
import com.valid.ui.component.main.ReceipeViewHolder
import com.valid.ui.component.main.RecipesListViewModel
import com.valid.ui.component.main.RecyclerItemListener
import com.valid.ui.component.main.TracksViewHolder

class TopTracksAdapter(private val newsListViewModel: RecipesListViewModel,
                       private val receipe: List<TrackItem?>? ) : RecyclerView.Adapter<TracksViewHolder>() {

    private val onItemClickListener: RecyclerItemListener = object : RecyclerItemListener {
        override fun onItemSelected(newsItem: ResponseGetTop) {
        }

        override fun onItemSelected(newsItem: ResponseGetTopTracks) {
            newsListViewModel.openTracks(newsItem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TracksViewHolder {
        val itemBinding = RecipesitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TracksViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: TracksViewHolder, position: Int) {
        holder.bind(receipe?.get(position)!!, onItemClickListener)
    }

    override fun getItemCount(): Int {
        return receipe!!.size
    }
}

