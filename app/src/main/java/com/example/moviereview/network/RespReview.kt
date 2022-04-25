package com.example.moviereview.network

import com.google.gson.annotations.SerializedName

data class ListResponse(
    @SerializedName("status")
    val status: String,

    @SerializedName("copyright")
    val copyright: String,

    @SerializedName("has_more")
    val hasMore: Boolean,

    @SerializedName("num_results")
    val numResults: Int,

    @SerializedName("results")
    val results: List<RespReview>
)

data class RespReview(
    @SerializedName("display_title")
    val name: String,

    @SerializedName("mpaa_rating")
    val rating: String,

    @SerializedName("critics_pick")
    val pick: Int,

    @SerializedName("byline")
    val biLine: String,

    @SerializedName("headline")
    val headline: String,

    @SerializedName("summary_short")
    val description: String,

    @SerializedName("publication_date")
    val pubDate: String,

    @SerializedName("opening_date")
    val openingDate: String,

    @SerializedName("date_updated")
    val dateUpdated: String,

    @SerializedName("link")
    val link: Link,

    @SerializedName("multimedia")
    val media: MultiMedia
)

data class Link(
    @SerializedName("type")
    val type: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("suggested_link_text")
    val sugLinkText: String
)

data class MultiMedia(
    @SerializedName("type")
    val type: String,

    @SerializedName("src")
    val src: String,

    @SerializedName("width")
    val width: Int,

    @SerializedName("height")
    val height: Int
)
