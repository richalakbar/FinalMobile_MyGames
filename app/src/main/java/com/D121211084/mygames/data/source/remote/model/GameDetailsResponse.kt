package com.D121211084.mygames.data.source.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameDetailsResponse(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "slug")
    val slug: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "name_original")
    val nameOriginal: String? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "metacritic")
    val metacritic: Int? = null,
    @Json(name = "metacritic_platforms")
    val metacriticPlatforms: List<MetacriticPlatform?>? = null,
    @Json(name = "released")
    val released: String? = null,
    @Json(name = "tba")
    val tba: Boolean? = null,
    @Json(name = "updated")
    val updated: String? = null,
    @Json(name = "background_image")
    val backgroundImage: String? = null,
    @Json(name = "background_image_additional")
    val backgroundImageAdditional: String? = null,
    @Json(name = "website")
    val website: String? = null,
    @Json(name = "rating")
    val rating: Double? = null,
    @Json(name = "rating_top")
    val ratingTop: Int? = null,
    @Json(name = "ratings")
    val ratings: List<Rating>? = null,
    @Json(name = "added")
    val added: Int? = null,
    @Json(name = "added_by_status")
    val addedByStatus: AddedByStatus? = null,
    @Json(name = "playtime")
    val playtime: Int? = null,
    @Json(name = "screenshots_count")
    val screenshotsCount: Int? = null,
    @Json(name = "movies_count")
    val moviesCount: Int? = null,
    @Json(name = "creators_count")
    val creatorsCount: Int? = null,
    @Json(name = "achievements_count")
    val achievementsCount: Int? = null,
    @Json(name = "parent_achievements_count")
    val parentAchievementsCount: Int? = null,
    @Json(name = "reddit_url")
    val redditUrl: String? = null,
    @Json(name = "reddit_name")
    val redditName: String? = null,
    @Json(name = "reddit_description")
    val redditDescription: String? = null,
    @Json(name = "reddit_logo")
    val redditLogo: String? = null,
    @Json(name = "reddit_count")
    val redditCount: Int? = null,
    @Json(name = "twitch_count")
    val twitchCount: Int? = null,
    @Json(name = "youtube_count")
    val youtubeCount: Int? = null,
    @Json(name = "reviews_text_count")
    val reviewsTextCount: Int? = null,
    @Json(name = "ratings_count")
    val ratingsCount: Int? = null,
    @Json(name = "suggestions_count")
    val suggestionsCount: Int? = null,
    @Json(name = "alternative_names")
    val alternativeNames: List<String?>? = null,
    @Json(name = "metacritic_url")
    val metacriticUrl: String? = null,
    @Json(name = "parents_count")
    val parentsCount: Int? = null,
    @Json(name = "additions_count")
    val additionsCount: Int? = null,
    @Json(name = "game_series_count")
    val gameSeriesCount: Int? = null,
    @Json(name = "user_game")
    val userGame: Any? = null,
    @Json(name = "reviews_count")
    val reviewsCount: Int? = null,
    @Json(name = "saturated_color")
    val saturatedColor: String? = null,
    @Json(name = "dominant_color")
    val dominantColor: String? = null,
    @Json(name = "parent_platforms")
    val parentPlatforms: List<ParentPlatform?>? = null,
    @Json(name = "platforms")
    val platforms: List<Platform?>? = null,
    @Json(name = "stores")
    val stores: List<Store?>? = null,
    @Json(name = "developers")
    val developers: List<Developer?>? = null,
    @Json(name = "genres")
    val genres: List<Genre?>? = null,
    @Json(name = "tags")
    val tags: List<Tag?>? = null,
    @Json(name = "publishers")
    val publishers: List<Publisher?>? = null,
    @Json(name = "esrb_rating")
    val esrbRating: EsrbRating? = null,
    @Json(name = "clip")
    val clip: Any? = null,
    @Json(name = "description_raw")
    val descriptionRaw: String? = null
) {
    @JsonClass(generateAdapter = true)
    data class MetacriticPlatform(
        @Json(name = "metascore")
        val metascore: Int? = null,
        @Json(name = "url")
        val url: String? = null,
        @Json(name = "platform")
        val platform: Platform? = null
    ) {
        @JsonClass(generateAdapter = true)
        data class Platform(
            @Json(name = "platform")
            val platform: Int? = null,
            @Json(name = "name")
            val name: String? = null,
            @Json(name = "slug")
            val slug: String? = null
        )
    }

    @JsonClass(generateAdapter = true)
    data class Rating(
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "title")
        val title: String? = null,
        @Json(name = "count")
        val count: Int? = null,
        @Json(name = "percent")
        val percent: Double? = null
    )

    @JsonClass(generateAdapter = true)
    data class AddedByStatus(
        @Json(name = "yet")
        val yet: Int? = null,
        @Json(name = "owned")
        val owned: Int? = null,
        @Json(name = "beaten")
        val beaten: Int? = null,
        @Json(name = "toplay")
        val toplay: Int? = null,
        @Json(name = "dropped")
        val dropped: Int? = null,
        @Json(name = "playing")
        val playing: Int? = null
    )

    @JsonClass(generateAdapter = true)
    data class ParentPlatform(
        @Json(name = "platform")
        val platform: Platform? = null
    ) {
        @JsonClass(generateAdapter = true)
        data class Platform(
            @Json(name = "id")
            val id: Int? = null,
            @Json(name = "name")
            val name: String? = null,
            @Json(name = "slug")
            val slug: String? = null
        )
    }

    @JsonClass(generateAdapter = true)
    data class Platform(
        @Json(name = "platform")
        val platform: Platform? = null,
        @Json(name = "released_at")
        val releasedAt: String? = null,
        @Json(name = "requirements")
        val requirements: Requirements? = null
    ) {
        @JsonClass(generateAdapter = true)
        data class Platform(
            @Json(name = "id")
            val id: Int? = null,
            @Json(name = "name")
            val name: String? = null,
            @Json(name = "slug")
            val slug: String? = null,
            @Json(name = "image")
            val image: Any? = null,
            @Json(name = "year_end")
            val yearEnd: Any? = null,
            @Json(name = "year_start")
            val yearStart: Int? = null,
            @Json(name = "games_count")
            val gamesCount: Int? = null,
            @Json(name = "image_background")
            val imageBackground: String? = null
        )

        @JsonClass(generateAdapter = true)
        data class Requirements(
            @Json(name = "minimum")
            val minimum: String? = null,
            @Json(name = "recommended")
            val recommended: String? = null
        )
    }

    @JsonClass(generateAdapter = true)
    data class Store(
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "url")
        val url: String? = null,
        @Json(name = "store")
        val store: Store? = null
    ) {
        @JsonClass(generateAdapter = true)
        data class Store(
            @Json(name = "id")
            val id: Int? = null,
            @Json(name = "name")
            val name: String? = null,
            @Json(name = "slug")
            val slug: String? = null,
            @Json(name = "domain")
            val domain: String? = null,
            @Json(name = "games_count")
            val gamesCount: Int? = null,
            @Json(name = "image_background")
            val imageBackground: String? = null
        )
    }

    @JsonClass(generateAdapter = true)
    data class Developer(
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "name")
        val name: String? = null,
        @Json(name = "slug")
        val slug: String? = null,
        @Json(name = "games_count")
        val gamesCount: Int? = null,
        @Json(name = "image_background")
        val imageBackground: String? = null
    )

    @JsonClass(generateAdapter = true)
    data class Genre(
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "name")
        val name: String? = null,
        @Json(name = "slug")
        val slug: String? = null,
        @Json(name = "games_count")
        val gamesCount: Int? = null,
        @Json(name = "image_background")
        val imageBackground: String? = null
    )

    @JsonClass(generateAdapter = true)
    data class Tag(
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "name")
        val name: String? = null,
        @Json(name = "slug")
        val slug: String? = null,
        @Json(name = "language")
        val language: String? = null,
        @Json(name = "games_count")
        val gamesCount: Int? = null,
        @Json(name = "image_background")
        val imageBackground: String? = null
    )

    @JsonClass(generateAdapter = true)
    data class Publisher(
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "name")
        val name: String? = null,
        @Json(name = "slug")
        val slug: String? = null,
        @Json(name = "games_count")
        val gamesCount: Int? = null,
        @Json(name = "image_background")
        val imageBackground: String? = null
    )

    @JsonClass(generateAdapter = true)
    data class EsrbRating(
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "name")
        val name: String? = null,
        @Json(name = "slug")
        val slug: String? = null
    )
}