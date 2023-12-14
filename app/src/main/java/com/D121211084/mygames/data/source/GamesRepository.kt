package com.D121211084.mygames.data.source

import com.D121211084.mygames.data.source.remote.model.GameDetailsResponse
import com.D121211084.mygames.data.source.remote.model.GamesResponse
import com.D121211084.mygames.vo.Resource
import kotlinx.coroutines.flow.Flow

interface GamesRepository {
    fun getAllGames(): Flow<Resource<List<GamesResponse.Game>>>
    fun searchGames(query: String): Flow<Resource<List<GamesResponse.Game>>>
//    suspend fun setIsFavorites(isFavorites: Boolean, id: Long)
//    fun getAllFavoritesGames(): Flow<List<Game>>
    fun getGameDetails(id: Long): Flow<Resource<GameDetailsResponse>>
}
