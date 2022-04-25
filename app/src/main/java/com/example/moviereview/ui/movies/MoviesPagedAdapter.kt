package com.example.moviereview.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviereview.databinding.ItemMovieBinding
import com.example.moviereview.network.RespReview

class MoviesPagedAdapter:PagingDataAdapter<RespReview, MoviesPagedAdapter.MovieViewHolder>(diffCallback) {

    inner class MovieViewHolder(val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: RespReview?) {
            binding.apply {
                movieName.text = movie?.name
                movieDesc.text = movie?.description
                Glide
                    .with(binding.root)
                    .load(movie?.media?.src)
                    .into(image)
            }
        }
    }

    companion object{
        val diffCallback = object : DiffUtil.ItemCallback<RespReview>() {
            override fun areItemsTheSame(oldItem: RespReview, newItem: RespReview): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: RespReview, newItem: RespReview): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.bind(currentItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}