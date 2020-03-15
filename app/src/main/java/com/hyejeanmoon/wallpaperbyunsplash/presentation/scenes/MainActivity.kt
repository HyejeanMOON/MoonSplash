package com.hyejeanmoon.wallpaperbyunsplash.presentation.scenes

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.hyejeanmoon.wallpaperbyunsplash.R
import com.hyejeanmoon.wallpaperbyunsplash.presentation.BaseActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    
}

@Module
abstract class MainActivityModule {
    @Binds
    abstract fun provideActivity(activity: MainActivity): FragmentActivity

    @Module
    abstract class Builder {
        @ContributesAndroidInjector(modules = [MainActivityModule::class])
        abstract fun contributeMainActivity(): MainActivity
    }
}
