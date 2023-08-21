package com.example.subject7

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    class MainActivity : AppCompatActivity(), QiitaTagRepository.ApiCallback {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            val repository = QiitaTagRepository()
            repository.fetchQiitaTag(this)
        }

        override fun onSuccess(result: List<Tag>) {
            Log.d("ApiTest", "$result")
        }

        override fun onFailure(t: Throwable) {
            Log.d("ApiTest", "$t")
        }
    }