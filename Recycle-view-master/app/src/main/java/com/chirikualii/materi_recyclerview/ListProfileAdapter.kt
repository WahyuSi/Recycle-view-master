package com.chirikualii.materi_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chirikualii.materi_recyclerview.databinding.ItemProfilHeaderBinding
import com.chirikualii.materi_recyclerview.databinding.ItemProfileBinding

class ListProfileAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    private val listProfile = mutableListOf<Profile>()
    private var viewType = -1
    class Holder(val binding: ItemProfileBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(data: Profile) {
            binding.tvName.text = data.name
            binding.tvPhone.text = data.phone
            Glide.with(itemView.context).load(data.image).circleCrop().into(binding.ivProfile);

        }
    }
    class holderHeader(val binding : ItemProfilHeaderBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(data: Profile) {
            binding.tvName.text = data.name
            binding.tvPhone.text = data.phone
            Glide.with(itemView.context).load(data.image).circleCrop().into(binding.ivProfile);

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)


        when(viewType){
            0 -> {
                val binding = ItemProfilHeaderBinding.inflate(layoutInflater,parent,false)
                return holderHeader(binding)
            }
            1 -> {
                val binding = ItemProfileBinding.inflate(layoutInflater,parent,false)
                return Holder(binding)
            }

            else ->{
                return null!!
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val profile = listProfile[position]

        when (viewType){
            0 -> {
                val holderProfileHeader = holder as holderHeader
                holderProfileHeader.bindView(profile)
            }
            1 -> {
                val holderProfile = holder as Holder
                holderProfile.bindView(profile)
            }
        }

    }

    override fun getItemCount(): Int {

        return listProfile.size

    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            viewType = 0
            return viewType
        } else {
            viewType = 1
           return viewType
        }

    }

    fun addlist(listData : List<Profile>){
        listProfile.clear()
        listProfile.addAll(listData)
    }
}