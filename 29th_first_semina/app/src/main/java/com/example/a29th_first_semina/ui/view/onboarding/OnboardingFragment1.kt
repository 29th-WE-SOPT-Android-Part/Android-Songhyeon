package com.example.a29th_first_semina.ui.view.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a29th_first_semina.R
import com.example.a29th_first_semina.databinding.FragmentOnboarding1Binding


class OnboardingFragment1 : Fragment() {
    private var _binding : FragmentOnboarding1Binding ?= null
    private val binding get() = _binding ?: error("뷰참조 실패얌")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboarding1Binding.inflate(
            inflater,
            container,
            false
        )

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment1_to_onboardingFragment2)
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}