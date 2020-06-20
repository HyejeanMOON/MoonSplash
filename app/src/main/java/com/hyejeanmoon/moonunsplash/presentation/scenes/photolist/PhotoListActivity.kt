package com.hyejeanmoon.moonunsplash.presentation.scenes.photolist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.hyejeanmoon.moonunsplash.R
import com.hyejeanmoon.moonunsplash.databinding.ActivityPhotoListBinding
import com.hyejeanmoon.moonunsplash.domain.scenes.collections.entity.Collections
import com.hyejeanmoon.moonunsplash.presentation.BaseActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

class PhotoListActivity : BaseActivity() {

    private lateinit var binding: ActivityPhotoListBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_photo_list)

        navController = Navigation.findNavController(this, R.id.nav_fragment)

    }

    companion object {
        private const val FLAG_COLLECTIONS = "COLLECTIONS"

        fun start(activity: Activity, collections: Collections) {
            val intent = Intent()
            intent.setClass(activity, PhotoListActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(FLAG_COLLECTIONS, collections)
            intent.putExtras(bundle)
            activity.startActivity(intent)
        }
    }
}

@Module
abstract class PhotoListActivityModule {
    @Binds
    abstract fun provideActivity(activity: PhotoListActivity): FragmentActivity

    @ContributesAndroidInjector
    abstract fun contributePhotoListFragment(): PhotoListFragment

    @Module
    abstract class Builder {
        @ContributesAndroidInjector(modules = [PhotoListActivityModule::class])
        abstract fun contributePhotoListActivity(): PhotoListActivity
    }
}
