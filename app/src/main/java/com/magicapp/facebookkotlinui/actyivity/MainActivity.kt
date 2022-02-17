package com.magicapp.facebookkotlinui.actyivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.magicapp.facebookkotlinui.R
import com.magicapp.facebookkotlinui.adapter.FeedAdapter
import com.magicapp.facebookkotlinui.model.Feed
import com.magicapp.facebookkotlinui.model.Post
import com.magicapp.facebookkotlinui.model.Story

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }
    fun initViews(){
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))

        refreshAdapter(getAllFeeds())
    }
    fun refreshAdapter(feeds: ArrayList<Feed>){
        val adapter = FeedAdapter(this, feeds)
        recyclerView.adapter = adapter
    }
    fun getAllFeeds(): ArrayList<Feed> {
        val stories: ArrayList<Story> = ArrayList()
        stories.add(Story(R.drawable.muslim_3, "Muslim"))
        stories.add(Story(R.drawable.muslim_3, "Muslim"))
        stories.add(Story(R.drawable.muslim_3, "Muslim"))
        stories.add(Story(R.drawable.muslim_3, "Muslim"))
        val feeds: ArrayList<Feed> = ArrayList()
        feeds.add(Feed())
        feeds.add(Feed(stories))
        feeds.add(Feed(Post(R.drawable.muslim_3, "Muslim", R.drawable.masjid_3)))
        feeds.add(Feed(Post(R.drawable.muslim_3, "Muslim", R.drawable.masjid_3)))
        feeds.add(Feed(Post(R.drawable.muslim_3, "Muslim", R.drawable.masjid_3)))
        feeds.add(Feed(Post(R.drawable.muslim_3, "Muslim", R.drawable.masjid_3)))
        return feeds
    }
}