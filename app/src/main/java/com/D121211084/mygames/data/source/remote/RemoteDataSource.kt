package com.D121211084.mygames.data.source.remote

import com.D121211084.mygames.data.source.remote.model.GameDetailsResponse
import com.D121211084.mygames.data.source.remote.model.GamesResponse
import com.D121211084.mygames.data.source.remote.web.ApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: ApiService) : ApiService {

    override suspend fun getAllGames(key: String, pageSize: Int): GamesResponse {
        return api.getAllGames()
    }

    override suspend fun searchGames(key: String, query: String): GamesResponse {
        return api.searchGames(query = query)
    }

    override suspend fun getGameDetails(id: Long, key: String): GameDetailsResponse {
        return api.getGameDetails(id = id)
    }

}