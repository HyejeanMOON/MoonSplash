package com.hyejeanmoon.moonunsplash.presentation.scenes.home.collections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hyejeanmoon.moonunsplash.R
import com.hyejeanmoon.moonunsplash.databinding.FragmentCollectionsBinding
import com.hyejeanmoon.moonunsplash.presentation.BaseFragment
import javax.inject.Inject

class CollectionsFragment : BaseFragment() {

    lateinit var binding: FragmentCollectionsBinding

    @Inject
    lateinit var viewModelFactory: CollectionsViewModel.Factory
    private val viewModel: CollectionsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)
            .get(CollectionsViewModel::class.java)
    }

    private lateinit var collectionsRecyclerViewAdapter: CollectionsRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_collections, container, false)

        collectionsRecyclerViewAdapter = CollectionsRecyclerViewAdapter()
        binding.recyclerView.adapter = collectionsRecyclerViewAdapter

        viewModel.getCollections()

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.getCollections()
            binding.swipeRefreshLayout.isRefreshing = false
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.getCollections().observe(viewLifecycleOwner, Observer {
            collectionsRecyclerViewAdapter.submitList(it)
        })
    }
}