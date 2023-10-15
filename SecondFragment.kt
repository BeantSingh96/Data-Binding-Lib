package com.example.databinding.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.databinding.R
import com.example.databinding.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = SecondFragment()
    }

    private lateinit var dataBinding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = FragmentSecondBinding.inflate(inflater, container, false)

        dataBinding.btn2.setOnClickListener {
            Navigation.findNavController(dataBinding.root)
                .navigate(R.id.action_secondFragment_to_thirdFragment)
        }
        return dataBinding.root
    }

}