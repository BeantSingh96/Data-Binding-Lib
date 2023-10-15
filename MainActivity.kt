package com.example.databinding.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databinding.adapter.MyAdapter
import com.example.databinding.R
import com.example.databinding.databinding.ActivityMainBinding
import com.example.databinding.repo.MyViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(dataBinding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment

        val navController = navHostFragment.navController

        navController.navigate(
            R.id.secondFragment,
            bundleOf("userId" to "someUser")
        )

//        val graph = inflater.inflate(R.navigation.nav_whatever)


//        viewModel = ViewModelProvider(this)[MyViewModel::class.java]
//
//        viewModel.newsModel.observe(this) { newsList ->
//
//            dataBinding.recyclerView.layoutManager = LinearLayoutManager(this)
//            dataBinding.recyclerView.adapter = MyAdapter(newsList)
//        }
//
//        viewModel.getNewsList()


    }
}