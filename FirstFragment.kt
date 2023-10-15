package com.example.databinding.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.databinding.R
import com.example.databinding.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var dataBinding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = FragmentFirstBinding.inflate(inflater, container, false)

        dataBinding.btn1.setOnClickListener {
            Navigation.findNavController(dataBinding.root)
                .navigate(R.id.action_firstFragment_to_secondFragment)
        }
        return dataBinding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}