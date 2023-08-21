package com.example.subject7

import android.util.Log
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

private fun getQiitaTag() {
    Thread {
        val client = OkHttpClient()
        val builder = HttpUrl.Builder()
            .scheme("https")
            .host("qiita.com")
            .addEncodedPathSegments("/api/v2/tags")
            .addQueryParameter("page", "1")
            .addQueryParameter("per_page", "10")
            .addQueryParameter("sort", "count")
        val request = Request.Builder()
            .url(builder.build().toString())
            .build()
        val response = client.newCall(request).execute()
        Log.d("OkHttpTest", "${response}")
    }.start()
}
