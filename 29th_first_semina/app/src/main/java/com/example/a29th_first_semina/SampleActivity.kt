package com.example.a29th_first_semina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a29th_first_semina.databinding.ActivitySampleBinding
import com.example.a29th_first_semina.ui.view.follwer.FollowerFragment
import com.example.a29th_first_semina.ui.view.repository.RepositoryFragment

class SampleActivity : AppCompatActivity() {
    private var position = FIRST_POSITION
    private lateinit var binding: ActivitySampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTransactionEvent()


    }

    fun initTransactionEvent(){
        val sampleFragment = FollowerFragment()
        val sampleFragment2 = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.container_sample, sampleFragment).commit()

        binding.btnChange.setOnClickListener{
            val transaction =  supportFragmentManager.beginTransaction()

            when (position){
                FIRST_POSITION -> {
                    transaction.replace(R.id.container_sample, sampleFragment2)
                    position = SECOND_POSITION
                }

                SECOND_POSITION -> {
                    transaction.replace(R.id.container_sample, sampleFragment)
                    position = FIRST_POSITION
                }
            }
            transaction.commit()
        }

    }




    companion object{
        const val FIRST_POSITION = 1
        const val SECOND_POSITION = 2
    }
}