package com.example.a29th_first_semina.ui.view.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a29th_first_semina.databinding.FragmentOnbording3Binding
import com.example.a29th_first_semina.ui.view.sigin.view.SignInActivity

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

        binding.btnNext.setOnClickListener {
            startActivity(Intent(context, SignInActivity::class.java))
            requireActivity().finish()
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}