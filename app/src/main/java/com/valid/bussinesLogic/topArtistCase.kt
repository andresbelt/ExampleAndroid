package com.valid.bussinesLogic

import androidx.lifecycle.MutableLiveData
import com.valid.data.Resource
import com.valid.data.dto.ResponseGetTop
import com.valid.data.dto.ResponseGetTopTracks

interface topArtistCase {
    fun getRecipes()
    fun getTopTracks()
    fun searchByTitle(keyWord: String): ResponseGetTop?
    val recipesLiveData: MutableLiveData<Resource<ResponseGetTop>>
    val tracksLiveData: MutableLiveData<Resource<ResponseGetTopTracks>>

}