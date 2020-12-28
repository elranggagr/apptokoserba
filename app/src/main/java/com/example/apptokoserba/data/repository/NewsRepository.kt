package com.example.apptokoserba.data.repository

import com.example.apptokoserba.data.model.ActionState
import com.example.apptokoserba.data.model.News
import com.example.apptokoserba.data.remote.NewsServices
import com.example.apptokoserba.data.remote.RetrofitApi
import retrofit2.await
import java.lang.Exception

class NewsRepository {
    private val newsServices: NewsServices by lazy { RetrofitApi.newsServices() }

    suspend fun listNews() : ActionState<List<News>> {
        return try {
            val list = newsServices.listNews().await()
            ActionState(list.data)
        }catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailNews(url: String) : ActionState<News> {
        return try {
            val list = newsServices.detailNews(url).await()
            ActionState(list.data.first())
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchNews(query: String) : ActionState<List<News>> {
        return try {
            val list = newsServices.searchNews(query).await()
            ActionState(list.data)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }
}
