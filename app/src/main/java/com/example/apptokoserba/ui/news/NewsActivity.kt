package com.example.apptokoserba.ui.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apptokoserba.R

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

    }

    companion object {
        const val OPEN_NEWS = "open_news"
    }
}

