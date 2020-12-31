package com.nobel.dhar.offer.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RequestInterceptor@Inject constructor(

) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest: Request.Builder = chain.request().newBuilder()

        newRequest.header("secret-key",
            "\$2b\$10\$vB5gvOv/K/w3ShFEsMwgi.8jH35CLT398iFNwZ1Gu5ELNXcQHbhQO")
        return chain.proceed(newRequest.build())
    }
}