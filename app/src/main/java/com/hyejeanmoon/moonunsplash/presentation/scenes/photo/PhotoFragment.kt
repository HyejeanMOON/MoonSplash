package com.hyejeanmoon.moonunsplash.presentation.scenes.photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.hyejeanmoon.moonunsplash.R
import com.hyejeanmoon.moonunsplash.databinding.FragmentPhotoBinding
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Photo
import com.hyejeanmoon.moonunsplash.presentation.BaseFragment

class PhotoFragment : BaseFragment() {

    private lateinit var binding: FragmentPhotoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photo, container, false)

        arguments?.also {
            val photo = it.getSerializable(PhotoActivity.FLAG_PHOTO) as Photo

            Glide.with(requireActivity()).load(photo.urls?.full).into(binding.imgViewPhoto)
        }

        return binding.root
    }

}