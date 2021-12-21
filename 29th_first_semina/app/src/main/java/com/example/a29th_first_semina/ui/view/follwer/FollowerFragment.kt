package com.example.a29th_first_semina.ui.view.follwer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.a29th_first_semina.R
import com.example.a29th_first_semina.databinding.FragmentFollowerBinding
import com.example.a29th_first_semina.ui.view.repository.RepositoryFragment


class FollowerFragment : Fragment() {
    private var _binding: FragmentFollowerBinding? = null
    private val binding get() = _binding ?: error("뷰를 참조하기 위해 바인딩이 초기화되지 않음")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(
            inflater,
            container,
            false
        )

        initImage()
        //initTransactionEvent()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val followerAdapter = FollowerAdapter()
        binding.rcvFollower.adapter = followerAdapter

        followerAdapter.follwerList.addAll(
            listOf<FollowerData>(
                FollowerData(R.drawable.dabeem,"문다빈", "안드파트장"),
                FollowerData(R.drawable.seunghyun,"한승현", "낭만 개발자"),
                FollowerData(R.drawable.me,"김송현","영원한 팔로워"),
                FollowerData(R.drawable.chisam,"치삼이","코딩하는 냐옹")
            )
        )

        followerAdapter.notifyDataSetChanged()
    }

    private fun initImage() {
        Glide.with(this)
            .load(R.drawable.me)
            .circleCrop()
            .into(binding.ivPhoto)
    }

    /*private fun initTransactionEvent() {

        val followerFragment = FollowerFragment()
        val repositoryFragment = RepositoryFragment()



        requireContext().supportFragmentManager.beginTransaction().add(R.id.frg_list, followerFragment).commit()



        binding.btnFollower.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frg_list, followerFragment).commit()
        }

        binding.btnRepogitory.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frg_list, repositoryFragment).commit()
        }
    }*/
}