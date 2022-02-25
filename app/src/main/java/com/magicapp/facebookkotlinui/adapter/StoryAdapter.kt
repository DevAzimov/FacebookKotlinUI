package com.magicapp.facebookkotlinui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.magicapp.facebookkotlinui.R
import com.magicapp.facebookkotlinui.model.Story

class StoryAdapter(var context: Context, var items: ArrayList<Story>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return 0
        }
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            val view = LayoutInflater.from(context).inflate(R.layout.item_feed_head, parent, false)
            return HeadStoryViewHolder(view)
        }
        val view = LayoutInflater.from(context).inflate(R.layout.item_story_view, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is StoryViewHolder) {
            holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class StoryViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Story) {
            val photo: ShapeableImageView = view.findViewById(R.id.iv_profile)
            val background: ShapeableImageView = view.findViewById(R.id.iv_background)
            val fullName: TextView = view.findViewById(R.id.tv_fullName)

            photo.setImageResource(item.profile)
            background.setImageResource(item.profile)
            fullName.text = item.fullName
        }
    }

    inner class HeadStoryViewHolder(view: View) : RecyclerView.ViewHolder(view)

}