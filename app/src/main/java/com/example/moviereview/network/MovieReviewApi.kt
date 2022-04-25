package com.example.moviereview.network

import com.example.moviereview.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieReviewApi {
    @GET("svc/movies/v2/reviews/search.json?&api-key=" + Constants.API_KEY)
    suspend fun getReviews(@Query("offset") page: Int): Response<ListResponse>
}