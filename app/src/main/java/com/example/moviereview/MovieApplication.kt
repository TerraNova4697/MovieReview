package com.example.moviereview

import android.app.Application
import com.example.moviereview.network.MovieReviewApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApplication: Application() {

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    var movieReviewApi: MovieReviewApi = retrofit.create(MovieReviewApi::class.java)

    override fun onCreate() {
        super.onCreate()
    }

}