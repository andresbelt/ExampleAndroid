package com.valid.data.server

import com.valid.data.Resource
import com.valid.data.dto.*

interface Source {
    //Geo.getTopArtists
    //Geo.getTopTracks

    suspend fun getTopTracks(): Resource<ResponseGetTopTracks>
    suspend fun getTopArtists(): Resource<ResponseGetTop>
}
