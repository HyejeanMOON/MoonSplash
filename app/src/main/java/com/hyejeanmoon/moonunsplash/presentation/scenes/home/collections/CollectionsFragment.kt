package com.hyejeanmoon.moonunsplash.presentation.scenes.home.collections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.hyejeanmoon.moonunsplash.R
import com.hyejeanmoon.moonunsplash.databinding.FragmentCollectionsBinding
import com.hyejeanmoon.moonunsplash.presentation.BaseFragment

class CollectionsFragment : BaseFragment() {

    lateinit var binding: FragmentCollectionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_collections, container, false)

        binding.recyclerView.adapter = CollectionsRecyclerViewAdapter()

        return binding.root

    }

}