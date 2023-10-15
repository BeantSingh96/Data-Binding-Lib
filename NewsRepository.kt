package com.example.databinding.repo

import android.util.Log
import com.example.databinding.ApiClient
import com.example.databinding.database.UserDao
import com.example.databinding.database.entity.UserEntity
import com.example.databinding.models.Data
import com.example.databinding.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepository(private val userDao: UserDao?) {

    private val remote = ApiClient.instance.service

    suspend fun getNewsApi(): List<UserEntity> {
        return withContext(Dispatchers.IO) {
            try {
                val response = remote?.getNewsList()

                if (response?.isSuccessful == true) {
                    response.body()?.let { news ->
                        val users = news.data.map { data ->
                            UserEntity().apply {
                                userId = data.user.userid
                                name = data.user.name
                                imageUrl = data.user.profilepicture
                            }
                        }

                        userDao?.deleteAll()

                        userDao?.insert(users)
                    }
                }
            } catch (e: Exception) {
                Log.d("output", "${e.message}")
            }
            userDao?.getUsers() ?: emptyList()
        }
    }
}