package com.hyejeanmoon.wallpaperbyunsplash.presentation.scenes.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.hyejeanmoon.wallpaperbyunsplash.R
import com.hyejeanmoon.wallpaperbyunsplash.databinding.FragmentPhotosBinding
import com.hyejeanmoon.wallpaperbyunsplash.presentation.BaseFragment
import javax.inject.Inject

class PhotosFragment : BaseFragment() {

    lateinit var binding: FragmentPhotosBinding

    @Inject
    lateinit var viewModelFactory: PhotosViewModel.Factory
    private val viewModel: PhotosViewModel by lazy {
        ViewModelProviders.of(requireActivity(), viewModelFactory)
            .get(PhotosViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photos, container, false)

        viewModel.getPhotoWithRandom()
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.photo.observe(viewLifecycleOwner, Observer { photo ->
            if (photo.urls != null) {
                Glide.with(this).load(photo.urls!!.regular).into(binding.img)
            }

        })
    }

}