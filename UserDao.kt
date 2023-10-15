package com.example.databinding.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.databinding.database.entity.UserEntity
import com.example.databinding.utils.Constants


@Dao
interface UserDao {

    @Upsert
    fun insert(users: List<UserEntity>)

    @Query("SELECT DISTINCT * FROM ${Constants.USER_TABLE}")
    fun getUsers(): List<UserEntity>

    @Query("DELETE FROM ${Constants.USER_TABLE}")
    fun deleteAll()
}