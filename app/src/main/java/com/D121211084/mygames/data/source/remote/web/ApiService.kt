package com.D121211084.mygames.data.source.remote.web

import com.D121211084.mygames.data.source.remote.model.GameDetailsResponse
import com.D121211084.mygames.data.source.remote.model.GamesResponse
import retrofit2.http.*
import java.util.*

interface ApiService {

    @GET("games")
    suspend fun getAllGames(
        @Query("key") key: String = "862839f9963f45e185ba6f6239259dd6",
        @Query("page_size") pageSize: Int = 50
    ): GamesResponse

    @GET("games")
    suspend fun searchGames(
        @Query("key") key: String = "862839f9963f45e185ba6f6239259dd6",
        @Query("search") query: String
    ): GamesResponse

    @GET("games/{id}")
    suspend fun getGameDetails(
        @Path("id") id: Long,
        @Query("key") key: String = "862839f9963f45e185ba6f6239259dd6"
    ): GameDetailsResponse

}