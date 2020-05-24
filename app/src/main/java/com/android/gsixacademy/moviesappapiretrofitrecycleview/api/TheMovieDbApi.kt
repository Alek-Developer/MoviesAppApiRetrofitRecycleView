package com.android.gsixacademy.moviesappapiretrofitrecycleview.api

import com.android.gsixacademy.moviesappapiretrofitrecycleview.models.PopularMovies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDbApi {

    @GET("/3/movie/popular")
    fun getpopularmovie(@Query("api_key") key: String): Call<PopularMovies>

}