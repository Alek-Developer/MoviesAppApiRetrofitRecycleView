package com.android.gsixacademy.moviesappapiretrofitrecycleview.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.gsixacademy.moviesappapiretrofitrecycleview.R
import com.android.gsixacademy.moviesappapiretrofitrecycleview.models.MovieResult
import com.android.gsixacademy.onlinezadaci1304.movies.MoviesAdapterClickEvent
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MoviesAdapter(
    val itemList: ArrayList<MovieResult>,
    val moviesAdapterClickEvent: (MoviesAdapterClickEvent) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_list_item, parent, false)
        )
    }
    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var myViewHolder = holder as MyViewHolder
        myViewHolder.bindData(itemList[position], position)
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(itemModel: MovieResult, position: Int) {
            Picasso.get().load("https://image.tmdb.org/t/p/w500/${itemModel.poster_path}").fit()
                .fit().into(itemView.image_view_movie)
            itemView.text_view_movie_title.text = itemModel.title
            itemView.text_view_movie_description.text = itemModel.overview
        }

    }

}
    