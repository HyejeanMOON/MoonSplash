package com.hyejeanmoon.moonunsplash.data.api.retrofit

import com.hyejeanmoon.moonunsplash.utils.LogUtils
import com.hyejeanmoon.moonunsplash.utils.MoonException
import retrofit2.Call
import retrofit2.Response

/**
 * ApiEnqueueCallback
 *
 * It's a callback for retrofit. the effect of this class is catch exception and output log.
 */
class ApiEnqueueCallback<T>(
    private val onSuccess: ((response: T) -> Unit),
    private val onError: ((Exception) -> Unit),
    private val retryMaxCount: Int = 0
) : ApiEnqueueCallbackBase<T>() {

    private lateinit var call: Call<T>

    override fun onResponse(call: Call<T>, response: Response<T>) {
        this.call = call

        val body = response.body() ?: throw MoonException(
            message = "code = $response.code().toString() , message = ${response.errorBody()
                .toString()}"
        )

        if (response.isSuccessful) {
            LogUtils.outputLog("response body: ${response.raw()}")
            onSuccess(body)
        } else {
            onError(
                MoonException(
                    message = "code = $response.code().toString() , message = ${response.errorBody()
                        .toString()}"
                )
            )
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