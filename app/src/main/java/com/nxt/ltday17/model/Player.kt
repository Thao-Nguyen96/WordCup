package com.nxt.ltday17.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("id")
    @Expose
    val id: Int? = null,

    @SerializedName("ten")
    @Expose
    val ten: String? = null,

    @SerializedName("doi")
    @Expose
    val doi: String? = null,

    @SerializedName("image")
    @Expose
    val image: String? = null,

    @SerializedName("social")
    @Expose
    val social: String? = null
)