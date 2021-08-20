package com.nxt.ltday17.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("id")
    @Expose
    val id: Int? = null,
    @SerializedName("doi1")
    @Expose
    val doi1: String? = null,

    @SerializedName("quocky1")
    @Expose
    val quocky1: String? = null,

    @SerializedName("doi2")
    @Expose
    val doi2: String? = null,

    @SerializedName("quocky2")
    @Expose
    val quocky2: String? = null,

    @SerializedName("ngay")
    @Expose
    val ngay: String? = null,

    @SerializedName("gio")
    @Expose
    val gio: String? = null,

    @SerializedName("vong")
    @Expose
    val vong: String? = null,

    @SerializedName("kenh")
    @Expose
    val kenh: String? = null
)