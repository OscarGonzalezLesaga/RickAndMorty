package gonzalez.oscar.network.base

import gonzalez.oscar.network.base.NetworkConfig.baseUrl
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseNetwork<T>(api: Class<T>) {

    var service: T = Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(api)
}