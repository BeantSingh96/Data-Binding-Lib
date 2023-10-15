package com.example.databinding.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.databinding.R
import com.example.databinding.databinding.FragmentFirstBinding
import com.example.databinding.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private lateinit var dataBinding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         dataBinding = FragmentThirdBinding.inflate(inflater, container, false)

        dataBinding.btn3.setOnClickListener {
            Navigation.findNavController(dataBinding.root)
                .navigate(R.id.action_thirdFragment_to_firstFragment)
        }
        return dataBinding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ThirdFragment()
    }
}