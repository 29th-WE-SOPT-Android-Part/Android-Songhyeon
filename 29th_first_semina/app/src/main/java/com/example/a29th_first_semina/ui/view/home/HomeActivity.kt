package com.example.a29th_first_semina.ui.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.a29th_first_semina.R
import com.example.a29th_first_semina.databinding.ActivityHomeBinding
import com.example.a29th_first_semina.ui.view.CameraFragment
import com.example.a29th_first_semina.ui.view.follwer.FollowerFragment
import com.example.a29th_first_semina.ui.view.repository.RepositoryFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtomNavigation()
        Toast.makeText(this, "김송현님 환영합니다", Toast.LENGTH_SHORT).show()
    }

    private fun initButtomNavigation(){

        supportFragmentManager.beginTransaction().add(R.id.frg_container, FollowerFragment()).commit()
        binding.bnvMenu.setOnItemSelectedListener {
            val transaction = supportFragmentManager.beginTransaction()

            when ( it.itemId){
                R.id.menu_home -> {
                    transaction.replace(R.id.frg_container,HomeFragment()).commit()
                }
                R.id.menu_profile -> {
                    transaction.replace(R.id.frg_container ,FollowerFragment()).commit()
                }

                R.id.menu_camera -> {
                    transaction.replace(R.id.frg_container, CameraFragment()).commit()
                }
            }
            true
        }


    }



}