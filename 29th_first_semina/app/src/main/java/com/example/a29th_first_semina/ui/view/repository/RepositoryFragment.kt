package com.example.a29th_first_semina.ui.view.repository

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a29th_first_semina.R
import com.example.a29th_first_semina.databinding.FragmentRepoBinding


class RepositoryFragment : Fragment() {
    private var _binding : FragmentRepoBinding ?= null
    private val binding get() = _binding ?: error("뷰 참조를 위해 바인딩이 초기화되지 않음")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentRepoBinding.inflate(
           inflater,
           container,
           false
       )
        divider()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repositoryAdapter = RepositoryAdapter()
        binding.rcvRepogitory.adapter = repositoryAdapter

        repositoryAdapter.repositoryList.addAll(
            listOf<RepositoryData>(
                RepositoryData("week1","first_level"),
                RepositoryData("week2","first_level"),
                RepositoryData("week3","엄청나게길게써야한다그래야보여줄수있기때문이다"),
            )

        )

        repositoryAdapter.notifyDataSetChanged()


    }

    private fun divider(){
        binding.rcvRepogitory.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
    }


}