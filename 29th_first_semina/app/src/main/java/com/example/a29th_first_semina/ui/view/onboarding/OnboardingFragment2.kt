package com.example.a29th_first_semina.ui.view.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.a29th_first_semina.R
import com.example.a29th_first_semina.databinding.FragmentOnboarding2Binding


class OnboardingFragment2 : Fragment() {
    private lateinit var binding : FragmentOnboarding2Binding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_onboarding2,container,false)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment2_to_onbordingFragment3)
        }
        return binding.root
    }



}