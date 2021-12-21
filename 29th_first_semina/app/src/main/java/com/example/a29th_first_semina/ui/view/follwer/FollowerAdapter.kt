package com.example.a29th_first_semina.ui.view.follwer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a29th_first_semina.R
import com.example.a29th_first_semina.databinding.ItemFollowerListBinding

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {

    val follwerList = mutableListOf<FollowerData>()

    class FollowerViewHolder(private val binding: ItemFollowerListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: FollowerData) {
            with(binding){
                tvName.text = data.name
                tvIntro.text = data.intro
                Glide.with(ivProfile.context)
                    .load(data.image)
                    .circleCrop().into(ivProfile)

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FollowerViewHolder {
        val binding = ItemFollowerListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return FollowerViewHolder(binding)

    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(follwerList[position])

    }



    override fun getItemCount(): Int = follwerList.size
}