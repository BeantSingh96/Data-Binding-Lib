package com.example.databinding.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.databinding.utils.Constants
import com.google.gson.annotations.SerializedName


@Entity(tableName = Constants.USER_TABLE)
class UserEntity {
    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: Int? = null

    @SerializedName("userid")
    @ColumnInfo(name = "user_Id")
    var userId: Int? = 0

    @SerializedName("name")
    @ColumnInfo(name = "name")
    var name: String? = null

    @SerializedName("profilepicture")
    @ColumnInfo(name = "photo_url")
    var imageUrl: String? = null
}