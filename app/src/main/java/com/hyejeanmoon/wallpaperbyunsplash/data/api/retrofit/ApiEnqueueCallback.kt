package com.hyejeanmoon.wallpaperbyunsplash.data.api.retrofit

import com.hyejeanmoon.wallpaperbyunsplash.utils.LogUtils
import com.hyejeanmoon.wallpaperbyunsplash.utils.MoonException
import retrofit2.Call
import retrofit2.Response

class ApiEnqueueCallback<T>(
    private val onSuccess: ((response: T) -> Unit),
    private val onError: ((Exception) -> Unit),
    private val retryMaxCount: Int = 0
) : ApiEnqueueCallbackBase<T>() {

    private lateinit var call: Call<T>

    override fun onResponse(call: Call<T>, response: Response<T>) {
        this.call = call

        val body = response.body() ?: throw MoonException()

        if (response.isSuccessful) {
            onSuccess(body)
        } else {
            onError(MoonException())
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        LogUtils.outputLog(
            "ApiEnqueueCallback#onFailure: requestUrl=%s,  stateOfCanceled=%s",
            call.request().url().uri().toString(),
            call.isCanceled
        )

        LogUtils.outputLog(t)

        onError(MoonException(t))
    }


}