package com.example.databinding.models

import android.util.Log

data class NewsModel(
    val `data`: List<Data> = emptyList(),
    val page: Int = 0,
    val per_page: Int = 0,
    val total_pages: Int = 0,
    val totalrecord: Int = 0
)

data class Data(
    val commentCount: Int = 0,
    val createdat: String = "",
    val description: String = "",
    val id: Int = 0,
    val location: String = "",
    val multiMedia: List<MultiMedia> = emptyList(),
    val title: String = "",
    val user: User = User()
)

data class MultiMedia(
    val createat: String = "",
    val description: String = "",
    val id: Int = 0,
    val name: String = "",
    val title: String = "",
    val url: String = ""
)

data class User(
    val name: String = "",
    val profilepicture: String = "",
    val userid: Int = 0
)