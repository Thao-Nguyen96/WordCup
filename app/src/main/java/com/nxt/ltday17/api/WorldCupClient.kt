package com.nxt.ltday17.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WorldCupClient {
    companion object {
        private var INSTANCE: Retrofit? = null

        fun getWorldCupClient(baseUrl: String): Retrofit? {
            if (INSTANCE == null) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }
    }
}