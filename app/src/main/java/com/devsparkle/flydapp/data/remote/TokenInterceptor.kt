package com.devsparkle.flydapp.data.remote

import com.devsparkle.flydapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val key = BuildConfig.KEY
        val secret = BuildConfig.SECRET
        val request = chain.request().newBuilder()
            .addHeader(
                "Authorization",
                "Discogs key=$key, secret=$secret"
            )
            .build()
        return chain.proceed(request)
    }
}
