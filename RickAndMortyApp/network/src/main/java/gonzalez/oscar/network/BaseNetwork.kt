package gonzalez.oscar.network

import gonzalez.oscar.network.NetworkConfig.baseUrl
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseNetwork {

    var service: Retrofit = Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}