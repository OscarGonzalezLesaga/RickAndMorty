package gonzalez.oscar.network

import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseNetwork {

    private val baseUrl = "https://rickandmortyapi.com/api/"

    var service: Retrofit = Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}