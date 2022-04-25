package com.example.moviereview.ui.movies

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviereview.R
import com.example.moviereview.databinding.FragmentMoviesBinding
import com.example.moviereview.ui.MoviesActivity
import kotlinx.coroutines.flow.collect

class MoviesFragment: Fragment(R.layout.fragment_movies) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val api = (activity as MoviesActivity).api
        val binding = FragmentMoviesBinding.bind(view)
        val moviesAdapter = MoviesPagedAdapter()

        binding.apply {
            rvMovies.apply{
                adapter = moviesAdapter
                layoutManager =LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }
        }

//        val viewModel: MoviesViewModel by viewModels()

        val viewModel: MoviesViewModel = MoviesViewModel(api)
        lifecycleScope.launchWhenCreated {
            viewModel.listData.collect { pagingData ->
                moviesAdapter.submitData(pagingData)
            }
        }
    }

}

