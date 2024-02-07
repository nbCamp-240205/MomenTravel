package com.android.traveltube.mypage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.traveltube.R

class MyVideoAdapter(
    private val itemList: List<MyVideoItem>,
    private val onItemClick: (position: Int) -> Unit,
    private val onItemLongClick: (position: Int) -> Unit
) : RecyclerView.Adapter<MyVideoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.myvideo_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun getItem(position: Int) {

    }

    fun removeItem(position: Int) {

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {

            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }

            itemView.setOnLongClickListener {
                onItemLongClick(adapterPosition)
                true
            }
        }
    }
}