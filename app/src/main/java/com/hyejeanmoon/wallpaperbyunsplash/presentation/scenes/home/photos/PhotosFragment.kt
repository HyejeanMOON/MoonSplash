package com.hyejeanmoon.wallpaperbyunsplash.presentation.scenes.home.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.hyejeanmoon.wallpaperbyunsplash.R
import com.hyejeanmoon.wallpaperbyunsplash.databinding.FragmentPhotosBinding
import com.hyejeanmoon.wallpaperbyunsplash.presentation.BaseFragment

class PhotosFragment : BaseFragment() {

    lateinit var binding: FragmentPhotosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photos, container, false)

        return binding.root

    }

}