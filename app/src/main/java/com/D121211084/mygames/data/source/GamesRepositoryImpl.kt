package com.D121211084.mygames.data.source

import com.D121211084.mygames.data.source.remote.RemoteDataSource
import com.D121211084.mygames.data.source.remote.model.GamesResponse
import com.D121211084.mygames.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : GamesRepository {

    override fun getAllGames(): Flow<Resource<List<GamesResponse.Game>>> = flow {
        try {
            val response = remoteDataSource.getAllGames()
            emit(Resource.Success(response.results.orEmpty()))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.onStart { emit(Resource.Loading) }.flowOn(Dispatchers.IO)

    override fun searchGames(query: String): Flow<Resource<List<GamesResponse.Game>>> = flow {
        try {
            val response = remoteDataSource.searchGames(query = query)
            emit(Resource.Success(response.results.orEmpty()))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.onStart { emit(Resource.Loading) }.flowOn(Dispatchers.IO)

    override fun getGameDetails(id: Long) = flow {
        try {
            val response = remoteDataSource.getGameDetails(id = id)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.onStart { emit(Resource.Loading) }.flowOn(Dispatchers.IO)

//    override suspend fun setIsFavorites(isFavorites: Boolean, id: Long) {
//        localDataSource.setIsFavorites(isFavorites, id)
//    }
//
//    override fun getAllFavoritesGames(): Flow<List<Game>> {
//        return localDataSource.getAllFavoriteGames().map { games ->
//            games.map { Game(it) }
//        }
//    }
//
//    override fun getGameDetails(id: Long): Flow<Game> {
//        return localDataSource.getGameDetail(id).map { Game(it) }
//    }
}
