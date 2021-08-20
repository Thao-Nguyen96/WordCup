package com.nxt.ltday17.api

class WorldCupUtil {
    companion object {
        private const val BASE_URL = "https://obscure-gorge-93598.herokuapp.com/"
        private val INSTANCE: WorldCupService? = null

        fun getWorCupService(): WorldCupService {
            return WorldCupClient.getWorldCupClient(BASE_URL)!!.create(WorldCupService::class.java)
        }
    }
}