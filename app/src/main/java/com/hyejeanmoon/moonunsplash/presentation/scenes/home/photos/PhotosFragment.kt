package com.hyejeanmoon.moonunsplash.presentation.scenes.home.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hyejeanmoon.moonunsplash.R
import com.hyejeanmoon.moonunsplash.databinding.FragmentPhotosBinding
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Photo
import com.hyejeanmoon.moonunsplash.presentation.BaseFragment
import com.hyejeanmoon.moonunsplash.presentation.scenes.photo.PhotoActivity
import javax.inject.Inject

class PhotosFragment : BaseFragment() {

    private lateinit var binding: FragmentPhotosBinding

    @Inject
    lateinit var viewModelFactory: PhotosViewModel.Factory
    private val viewModel: PhotosViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)
            .get(PhotosViewModel::class.java)
    }

    private lateinit var adapter: PhotosRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photos, container, false)

        adapter =
            PhotosRecyclerViewAdapter(::startActivity)

        binding.rercyclerView.adapter = adapter
        binding.rercyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.getPhotoWithLatest()

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.getPhotoWithLatest()
            binding.swipeRefreshLayout.isRefreshing = false
        }

        return binding.root

    }

    private fun startActivity(photo: Photo) {
        activity?.also {
            PhotoActivity.start(it, photo)
        }
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