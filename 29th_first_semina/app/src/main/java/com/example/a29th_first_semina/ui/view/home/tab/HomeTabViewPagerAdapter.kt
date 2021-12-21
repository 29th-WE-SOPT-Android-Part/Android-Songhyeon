package com.example.a29th_first_semina.ui.view.home.tab

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeTabViewPagerAdapter(fragment : Fragment) :
FragmentStateAdapter(fragment)
{
    val fragments = mutableListOf<Fragment>()

    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
}