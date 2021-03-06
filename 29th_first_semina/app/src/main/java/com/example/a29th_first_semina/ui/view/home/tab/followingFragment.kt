package com.example.a29th_first_semina.ui.view.home.tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a29th_first_semina.R
import com.example.a29th_first_semina.databinding.FragmentFollowingBinding


class followingFragment : Fragment() {
    private var _binding : FragmentFollowingBinding? = null
    private val binding get() = _binding ?: error("뷰참조실패여")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentFollowingBinding.inflate(
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