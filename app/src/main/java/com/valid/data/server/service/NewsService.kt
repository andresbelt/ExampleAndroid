package com.valid.data.server.service

import com.valid.data.dto.ResponseGetTop
import com.valid.data.dto.ResponseGetTopTracks
import retrofit2.Response
import retrofit2.http.GET

interface NewsService {
    @GET("?method=geo.gettoptracks&country=spain&api_key=829751643419a7128b7ada50de590067&format=json")
    suspend fun fetchTopTracks():Response<ResponseGetTopTracks>

    @GET("?method=geo.gettopartists&country=spain&api_key=829751643419a7128b7ada50de590067&format=json")
    suspend fun fetchTopArtists():Response<ResponseGetTop>
}
