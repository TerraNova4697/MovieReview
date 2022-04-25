package com.example.moviereview.ui.movies

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.*
import com.example.moviereview.Constants
import com.example.moviereview.network.MovieReviewApi
import com.example.moviereview.network.RespReview
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class MoviesViewModel(
    private val movieReviewApi: MovieReviewApi
): ViewModel() {

//    private var retrofit: Retrofit = Retrofit.Builder()
//        .baseUrl(Constants.BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//    private var movieReviewApi: MovieReviewApi  = retrofit.create(MovieReviewApi::class.java)

    val listData = Pager(PagingConfig(pageSize = 1)) {
        MoviesPagingSource(movieReviewApi)
    }.flow.cachedIn(viewModelScope)
}

class MoviesPagingSource(
    private val movieReviewApi: MovieReviewApi
): PagingSource<Int, RespReview>() {
    override fun getRefreshKey(state: PagingState<Int, RespReview>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RespReview> {
        return try {
            val currentPage = params.key ?: 1
            val response = movieReviewApi.getReviews(currentPage)
            val data = response.body()?.results ?: emptyList()
            val responseData = mutableListOf<RespReview>()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(20)
            )
        } catch (e: Exception) {
            Log.e("MyTag", "Error $e")
            LoadResult.Error(e)
        }
    }
}