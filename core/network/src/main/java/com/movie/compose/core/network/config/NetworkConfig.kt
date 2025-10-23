package com.movie.compose.core.network.config

import com.movie.compose.core.network.BuildConfig

object NetworkConfig {

    val TMDB_BASE_URL get() = BuildConfig.TMDB_BASE_URL
    val TMDB_API_KEY get() = BuildConfig.TMDB_API_KEY
    val TMDB_BASE_URL_IMAGE_200 get() = BuildConfig.TMDB_BASE_URL_IMAGE_200
    val TMDB_BASE_URL_IMAGE_500 get() = BuildConfig.TMDB_BASE_URL_IMAGE_500
    val TMDB_BASE_URL_IMAGE_ORIGINAL get() = BuildConfig.TMDB_BASE_URL_IMAGE_ORIGINAL


    val ITUNES_BASE_URL get() = BuildConfig.ITUNES_BASE_URL
}
