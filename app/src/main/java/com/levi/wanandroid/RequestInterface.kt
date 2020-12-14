package com.levi.wanandroid

import com.levi.wanandroid.entity.Articles
import retrofit2.Call
import retrofit2.http.GET

interface RequestInterface {

    /**
     * 首页文章列表
     */
    @GET("article/list/0/json")
    fun getHomeArticles(): Call<Articles>
}