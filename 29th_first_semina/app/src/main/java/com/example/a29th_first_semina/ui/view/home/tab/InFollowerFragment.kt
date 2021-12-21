package com.example.a29th_first_semina.ui.view.home.tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a29th_first_semina.R
import com.example.a29th_first_semina.databinding.FragmentInFollowerBinding


class InFollowerFragment : Fragment() {
    private var _binding : FragmentInFollowerBinding? = null
    private val binding get() = _binding ?: error("뷰 참조 실패")



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInFollowerBinding.inflate(
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