package com.example.a29th_first_semina.ui.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a29th_first_semina.R
import com.example.a29th_first_semina.databinding.ActivityHomeBinding
import com.example.a29th_first_semina.ui.view.follwer.FollowerFragment
import com.example.a29th_first_semina.ui.view.repository.RepositoryFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, "김송현님 환영합니다", Toast.LENGTH_SHORT).show()
        initTransactionEvent()
    }

    private fun initTransactionEvent() {

        val followerFragment = FollowerFragment()
        val repositoryFragment = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.frg_list, followerFragment).commit()

        binding.btnFollower.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frg_list, followerFragment).commit()
        }

        binding.btnRepogitory.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frg_list, repositoryFragment).commit()
        }

    }


}