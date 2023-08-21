package com.example.subject7

import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // GETで投げるか、POSTで投げるかをアノテーションで指定
    // パスを記載する
    @GET("api/v2/tags")
    // @Queryでパラメーターを指定する
    fun getQiitaTags(@Query("page") page: Int, @Query("per_page") parPage: Int, @Query("sort") sort: String) : Call<List<Tag>>
}