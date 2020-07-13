package com.valid.ui.component.main

import com.valid.data.dto.ResponseGetTop
import com.valid.data.dto.ResponseGetTopTracks


interface RecyclerItemListener {
    fun onItemSelected(newsItem: ResponseGetTop)
    fun onItemSelected(newsItem: ResponseGetTopTracks)

}