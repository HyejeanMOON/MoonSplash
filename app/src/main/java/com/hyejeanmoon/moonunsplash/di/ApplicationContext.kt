package com.hyejeanmoon.moonunsplash.di

import javax.inject.Qualifier

/**
 * ApplicationContext
 *
 * Context of Android is created by Dagger. Using method is add a [@ApplicationContext] tag.
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationContext