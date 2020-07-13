package com.valid.data

import com.valid.data.dto.ResponseGetTop
import com.valid.data.dto.ResponseGetTopTracks
import com.valid.data.server.RemoteRepository
import com.valid.data.server.Source
import javax.inject.Inject

class DataRepository @Inject
constructor(
    private val remoteRepository: RemoteRepository) :
    Source {

    override suspend fun getTopTracks(): Resource<ResponseGetTopTracks> {
        return remoteRepository.getTopTracks()
    }

    override suspend fun getTopArtists(): Resource<ResponseGetTop> {
        return remoteRepository.getTopArtists()
    }
}