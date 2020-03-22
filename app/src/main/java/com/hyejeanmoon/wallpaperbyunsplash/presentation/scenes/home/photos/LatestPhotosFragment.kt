package com.hyejeanmoon.wallpaperbyunsplash.presentation.scenes.home.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hyejeanmoon.wallpaperbyunsplash.R
import com.hyejeanmoon.wallpaperbyunsplash.databinding.FragmentPhotosBinding
import com.hyejeanmoon.wallpaperbyunsplash.presentation.BaseFragment
import com.hyejeanmoon.wallpaperbyunsplash.presentation.scenes.home.adapter.PhotosRecyclerViewAdapter
import javax.inject.Inject

class LatestPhotosFragment : BaseFragment() {

    lateinit var binding: FragmentPhotosBinding

    @Inject
    lateinit var viewModelFactory: PhotosViewModel.Factory
    private val viewModel: PhotosViewModel by lazy {
        ViewModelProviders.of(requireActivity(), viewModelFactory)
            .get(PhotosViewModel::class.java)
    }

    private lateinit var adapter: PhotosRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photos, container, false)

        adapter = PhotosRecyclerViewAdapter()

        binding.rercyclerView.adapter = adapter
        binding.rercyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.getPhotoWithLatest()

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.getPhotoWithLatest().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

}