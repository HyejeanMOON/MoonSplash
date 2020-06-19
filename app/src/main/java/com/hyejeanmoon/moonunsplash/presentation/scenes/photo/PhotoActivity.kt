package com.hyejeanmoon.moonunsplash.presentation.scenes.photo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.hyejeanmoon.moonunsplash.R
import com.hyejeanmoon.moonunsplash.databinding.ActivityPhotoBinding
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Photo
import com.hyejeanmoon.moonunsplash.presentation.BaseActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

class PhotoActivity : BaseActivity() {

    private lateinit var binding: ActivityPhotoBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_photo)
        navController = Navigation.findNavController(this, R.id.nav_fragment)

        val bundle = intent.extras

        navController.navigate(R.id.photoFragment, bundle)

        setStatusBarColor(R.color.colorPrimary, true)

    }

    companion object {
        const val FLAG_PHOTO = "PHOTO"

        fun start(activity: Activity, photo: Photo) {
            val intent = Intent()
            val bundle = Bundle()
            bundle.putSerializable(FLAG_PHOTO, photo)
            intent.putExtras(bundle)
            intent.setClass(activity, PhotoActivity::class.java)
            activity.startActivity(intent)
        }
    }
}

@Module
abstract class PhotoActivityModule {
    @Binds
    abstract fun provideActivity(activity: PhotoActivity): FragmentActivity

    @ContributesAndroidInjector
    abstract fun contributePhotoFragment(): PhotoFragment

    @Module
    abstract class Builder {
        @ContributesAndroidInjector(modules = [PhotoActivityModule::class])
        abstract fun contributePhotoActivity(): PhotoActivity
    }
}