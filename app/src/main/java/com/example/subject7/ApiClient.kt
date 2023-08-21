package com.example.subject7

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    val service: ApiService
        get() {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://qiita.com/")
                .addConverterFactory(GsonConverterFactory.create()) // パーサーにGsonを指定
                .client(client)
                .build()
            return retrofit.create(ApiService::class.java)
        }

    private val client: OkHttpClient
        get() {
            val builder = OkHttpClient.Builder().also {
                it.addInterceptor { chain ->
                    // リクエストに対して設定を行う
                    val currentRequest = chain.request()
                    val newRequest = currentRequest.newBuilder()
                        .header("Accept", "application/json") // リクエストヘッダーを追加
                        .method(currentRequest.method, currentRequest.body)
                        .build()
                    return@addInterceptor chain.proceed(newRequest)
                }
            }.readTimeout(30, TimeUnit.SECONDS)
            return builder.build()
        }

    companion object {
        private var instance: ApiClient? = null
        fun newInstance() = instance ?: synchronized(this) {
            instance ?: ApiClient().also { instance = it }
        }
    }
}