package com.example.databinding.repo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.databinding.database.AppDatabase
import com.example.databinding.database.entity.UserEntity
import kotlinx.coroutines.launch

class MyViewModel(app: Application) : AndroidViewModel(app) {

    private val _newsModel = MutableLiveData<List<UserEntity>>()
    val newsModel: LiveData<List<UserEntity>> = _newsModel

    private val repository =
        NewsRepository(AppDatabase.getInstance(app.applicationContext)?.userDao)

    fun getNewsList() {

        viewModelScope.launch {

            _newsModel.value = repository.getNewsApi()
        }
    }
}