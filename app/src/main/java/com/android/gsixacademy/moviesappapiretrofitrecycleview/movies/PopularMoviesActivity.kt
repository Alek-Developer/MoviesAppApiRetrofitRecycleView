package com.android.gsixacademy.moviesappapiretrofitrecycleview.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.gsixacademy.moviesappapiretrofitrecycleview.R
import com.android.gsixacademy.moviesappapiretrofitrecycleview.api.ServiceBuilder
import com.android.gsixacademy.moviesappapiretrofitrecycleview.api.TheMovieDbApi
import com.android.gsixacademy.moviesappapiretrofitrecycleview.models.PopularMovies
import kotlinx.android.synthetic.main.activity_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularMoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        val request = ServiceBuilder.buildService(TheMovieDbApi::class.java)

        val call = request.getpopularmovie("8dd3a40cdacd660d79bce7c46bad942e")
        Log.d("moviesList", "{?.size}")

        call.enqueue(object : Callback<PopularMovies> {
            override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
                if (response.isSuccessful) {

                    val popularMovies = response.body()

                    val moviesList = popularMovies?.results

                    Log.d("moviesList", "${moviesList?.size}")
                    // do something with response

                    if (moviesList != null) {
                        var moviesAdapter = MoviesAdapter(moviesList) {}
                        recycler_view_activity.adapter = moviesAdapter
                    }
                }
            }
            override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                // show the error
            }
        })
    }
}
