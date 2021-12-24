package com.example.a29th_first_semina.ui.view.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a29th_first_semina.databinding.FragmentOnbording3Binding

class OnbordingFragment3 : Fragment() {
    private var _binding : FragmentOnbording3Binding ?= null
    private val binding get() = _binding ?: error("뷰참조실패")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnbording3Binding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}