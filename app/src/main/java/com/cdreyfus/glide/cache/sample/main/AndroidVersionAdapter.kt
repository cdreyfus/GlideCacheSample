package com.cdreyfus.glide.cache.sample.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cdreyfus.glide.cache.sample.configuration.AndroidLogo
import com.cdreyfus.glide.cache.sample.R

class AndroidVersionAdapter(private val versionsList: List<AndroidLogo>) :
    RecyclerView.Adapter<AndroidVersionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AndroidVersionViewHolder {
        return AndroidVersionViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AndroidVersionViewHolder, position: Int) {
        holder.bind(versionsList[position])
    }

    override fun getItemCount(): Int {
        return versionsList.size
    }

}

class AndroidVersionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: AndroidLogo) {
        Glide.with(itemView)
            .load(item)
            .onlyRetrieveFromCache(true)
            .into(itemView.findViewById(R.id.image))
    }

}
