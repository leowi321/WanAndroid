package com.levi.wanandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.levi.wanandroid.entity.Articles
import com.levi.wanandroid.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    private fun getData() {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val ipService = retrofit.create(RequestInterface::class.java)
        ipService.getHomeArticles().enqueue(object : Callback<Articles> {
            override fun onResponse(call: Call<Articles>, response: Response<Articles>) {
                Log.d("haha", "success response ${response.body()}")
            }

            override fun onFailure(call: Call<Articles>, t: Throwable) {
                Log.d("haha", "onFailure")
            }
        })
    }
}