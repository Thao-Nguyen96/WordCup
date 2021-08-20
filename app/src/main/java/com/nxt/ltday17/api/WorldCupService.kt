package com.nxt.ltday17.api

import com.nxt.ltday17.model.Match
import com.nxt.ltday17.model.Player
import retrofit2.Call
import retrofit2.http.GET

interface WorldCupService {

    @GET("lichthidau/all")
    fun getAllMatches(): Call<List<Match>>

    @GET("cauthu/all")
    fun getAllPlayer(): Call<List<Player>>
}