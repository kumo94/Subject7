package com.example.subject7

import com.google.gson.annotations.SerializedName

class Tag {
    @SerializedName("followers_count")
    var followersCount = 0

    @SerializedName("icon_url")
    var iconUrl: String? = null

    @SerializedName("id")
    var tagId: String? = null

    @SerializedName("items_count")
    var itemCount = 0
}