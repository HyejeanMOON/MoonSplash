package com.hyejeanmoon.wallpaperbyunsplash.presentation.scenes.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayout
import com.hyejeanmoon.wallpaperbyunsplash.R
import com.hyejeanmoon.wallpaperbyunsplash.databinding.ActivityHomeBinding
import com.hyejeanmoon.wallpaperbyunsplash.presentation.BaseActivity
import com.hyejeanmoon.wallpaperbyunsplash.presentation.scenes.home.adapter.HomeFragmentPagerAdapter
import com.hyejeanmoon.wallpaperbyunsplash.presentation.scenes.home.photos.PhotosFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        setStatusBarColor(R.color.colorPrimary, true)

        binding.viewpager.adapter = HomeFragmentPagerAdapter(
            fragment = arrayListOf(PhotosFragment(), PhotosFragment()),
            fragmentManager = supportFragmentManager
        )

        binding.tabLayout.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(binding.viewpager))
        binding.viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))

        setSupportActionBar(toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.photo_order_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.latest -> {

            }
            R.id.oldest -> {

            }
            R.id.popular -> {

            }
        }

        return true
    }

}

@Module
abstract class HomeActivityModule {
    @Binds
    abstract fun provideActivity(activity: HomeActivity): FragmentActivity

    @ContributesAndroidInjector
    abstract fun contributePhotosFragment(): PhotosFragment

    @Module
    abstract class Builder {
        @ContributesAndroidInjector(modules = [HomeActivityModule::class])
        abstract fun contributeMainActivity(): HomeActivity
    }
}
