package com.hyejeanmoon.moonunsplash.data.api.retrofit

import com.hyejeanmoon.moonunsplash.utils.LogUtils
import okhttp3.Interceptor
import okhttp3.Response

/**
 * ApiInterceptor
 *
 * It's a Interceptor for Retrofit, in order to push [client-id] in header to the Unsplash server.
 */
class ApiInterceptor(private val clientId: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Client-ID $clientId")
            .build()

        LogUtils.outputLog(request.toString())

        return chain.proceed(request)
    }
}