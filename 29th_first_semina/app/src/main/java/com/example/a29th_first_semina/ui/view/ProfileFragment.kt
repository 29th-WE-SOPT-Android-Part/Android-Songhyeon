package com.example.a29th_first_semina.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.a29th_first_semina.R
import com.example.a29th_first_semina.databinding.FragmentProfileBinding
import com.example.a29th_first_semina.ui.view.follwer.FollowerFragment
import com.example.a29th_first_semina.ui.view.repository.RepositoryFragment


class ProfileFragment : Fragment() {
    private var _binding : FragmentProfileBinding ?= null
    private val binding get() = _binding?: error("뷰참조 실패")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(
            inflater,
            container,
            false
        )
        initImage()
        initTransactionEvent()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initImage() {
        Glide.with(this)
            .load(R.drawable.me)
            .circleCrop()
            .into(binding.ivPhoto)
    }

    private fun initTransactionEvent() {

        val followerFragment = FollowerFragment()
        val repositoryFragment = RepositoryFragment()

        childFragmentManager.beginTransaction().add(R.id.frg_list, followerFragment).commit()
        binding.btnFollower.isSelected = true
        binding.btnRepogitory.isSelected = false

        binding.btnFollower.setOnClickListener {
            binding.btnFollower.isSelected = true
            binding.btnRepogitory.isSelected = false
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.frg_list, followerFragment).commit()
        }

        binding.btnRepogitory.setOnClickListener {
            binding.btnFollower.isSelected = false
            binding.btnRepogitory.isSelected = true
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.frg_list, repositoryFragment).commit()
        }
    }


}