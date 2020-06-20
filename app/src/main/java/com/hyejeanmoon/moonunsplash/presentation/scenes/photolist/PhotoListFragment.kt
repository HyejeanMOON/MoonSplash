package com.hyejeanmoon.moonunsplash.presentation.scenes.photolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.hyejeanmoon.moonunsplash.R
import com.hyejeanmoon.moonunsplash.databinding.FragmentPhotoListBinding
import com.hyejeanmoon.moonunsplash.presentation.BaseFragment

class PhotoListFragment : BaseFragment() {

    private lateinit var binding: FragmentPhotoListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photo_list, container, false)

        return binding.root
    }
}