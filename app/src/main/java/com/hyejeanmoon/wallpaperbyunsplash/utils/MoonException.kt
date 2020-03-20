package com.hyejeanmoon.wallpaperbyunsplash.utils

class MoonException(
    cause: Throwable? = null,
    message: String? = null
) : Exception(message, cause) {
    override fun toString(): String {

        return "${this::class.java.simpleName} cause=${cause?.message}  message=${message} "
    }
}