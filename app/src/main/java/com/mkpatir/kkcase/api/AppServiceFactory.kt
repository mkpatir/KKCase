package com.mkpatir.kkcase.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppServiceFactory {

    private const val BASE_URL = "https://example.com"

    fun buildService(
        authTokenInterceptor: AuthTokenInterceptor
    ): AppService{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(buildHttpClient(authTokenInterceptor))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(AppService::class.java)
    }

    private fun buildHttpClient(authTokenInterceptor: AuthTokenInterceptor): OkHttpClient{
        val okHttpClientBuilder = OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            addInterceptor(authTokenInterceptor)
        }
        return okHttpClientBuilder.build()
    }
}