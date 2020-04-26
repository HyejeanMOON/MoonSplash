package com.hyejeanmoon.moonunsplash.presentation.scenes.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.hyejeanmoon.moonunsplash.R
import com.hyejeanmoon.moonunsplash.data.scenes.photos.LatestPhotosFragment
import com.hyejeanmoon.moonunsplash.databinding.ActivityHomeBinding
import com.hyejeanmoon.moonunsplash.presentation.BaseActivity
import com.hyejeanmoon.moonunsplash.presentation.scenes.home.photos.PhotosFragment
import com.hyejeanmoon.moonunsplash.presentation.scenes.home.photos.PhotosViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var navController: NavController

    @Inject
    lateinit var viewModelFactory: PhotosViewModel.Factory
    private val viewModel: PhotosViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)
            .get(PhotosViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        navController = Navigation.findNavController(this, R.id.nav_fragment)

        setStatusBarColor(R.color.colorPrimary, true)

        setSupportActionBar(toolbar)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    override fun onBackPressed() {
        finish()
    }

}

@Module
abstract class HomeActivityModule {
    @Binds
    abstract fun provideActivity(activity: HomeActivity): FragmentActivity

    @ContributesAndroidInjector
    abstract fun contributePopularPhotosFragment(): PhotosFragment

    @ContributesAndroidInjector
    abstract fun contributeLatestPhotosFragment(): LatestPhotosFragment

    @Module
    abstract class Builder {
        @ContributesAndroidInjector(modules = [HomeActivityModule::class])
        abstract fun contributeMainActivity(): HomeActivity
    }
}
