package com.valid.data.server

import com.valid.data.Resource
import com.valid.data.ServiceGenerator
import com.valid.data.dto.ResponseGetTop
import com.valid.data.dto.ResponseGetTopTracks
import com.valid.data.server.service.NewsService
import com.valid.data.server.service.SafeApiRequest
import javax.inject.Inject

class RemoteRepository @Inject
constructor(private val serviceGenerator: ServiceGenerator) : Source, SafeApiRequest()  {

    override suspend fun getTopTracks(): Resource<ResponseGetTopTracks>{
        val newsService = serviceGenerator.createService(NewsService::class.java)
        val context = HashMap<String, String>()

        val response = processCall { (newsService::fetchTopTracks)() }

        return when (response) {
            is ResponseGetTopTracks -> {
                Resource.Success(data = response)
            }
            else -> {
                Resource.DataError(1)
            }
        }
    }


    override suspend fun getTopArtists(): Resource<ResponseGetTop> {
        val newsService = serviceGenerator.createService(NewsService::class.java)
        val context = HashMap<String, String>()

        val response = processCall { (newsService::fetchTopArtists)() }

        return Resource.Success(data = response)
    }


}