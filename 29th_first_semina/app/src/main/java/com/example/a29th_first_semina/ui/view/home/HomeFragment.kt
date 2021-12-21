package com.example.a29th_first_semina.ui.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a29th_first_semina.databinding.FragmentHomeBinding
import com.example.a29th_first_semina.ui.view.home.tab.HomeTabViewPagerAdapter
import com.example.a29th_first_semina.ui.view.home.tab.InFollowerFragment
import com.example.a29th_first_semina.ui.view.home.tab.followingFragment
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding ?: error("뷰를 참조하기 위해 바인딩이 초기화되지 않음")
    private lateinit var homeTabViewPagerAdapter : HomeTabViewPagerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )
        initAdpater()
        initTabLayout()
        return binding.root
    }


    private fun initAdpater(){
        val fragmentList = listOf(followingFragment(),InFollowerFragment())
        homeTabViewPagerAdapter = HomeTabViewPagerAdapter(this)
        homeTabViewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpTab.adapter = homeTabViewPagerAdapter
        binding.vpTab.isSaveEnabled = false
    }

    private fun initTabLayout() {
        val tabList = listOf("팔로잉", "팔로워")

        TabLayoutMediator(binding.tlFollow, binding.vpTab) {
            tab, position ->
            tab.text = tabList[position]
        }.attach()

        binding.vpTab.isUserInputEnabled = false

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    }

