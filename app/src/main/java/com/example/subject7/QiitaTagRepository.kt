package com.example.subject7

import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response

class QiitaTagRepository {

    fun fetchQiitaTag(listener: ApiCallback) {
        ApiClient.newInstance().service.getQiitaTags(page = 1, perPage = 10, sort = "count")
            .enqueue(object : Callback<List<Tag>> {
                override fun onResponse(call: Call<List<Tag>>, response: Response<List<Tag>>) {
                    if (response.isSuccessful) {
                        // 通信成功
                        listener.onSuccess(response.body().orEmpty())
                    } else {
                        onFailure(call, IllegalStateException("Api Access Failure"))
                    }
                }

                override fun onFailure(call: Call<List<Tag>>, t: Throwable) {
                    listener.onFailure(t)
                }
            })
    }

    interface ApiCallback {
        fun onSuccess(result: List<Tag>)
        fun onFailure(t: Throwable)
    }
}