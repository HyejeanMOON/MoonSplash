package com.hyejeanmoon.moonunsplash.presentation.scenes.home.collections

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hyejeanmoon.moonunsplash.R
import com.hyejeanmoon.moonunsplash.databinding.ItemPhotoBinding
import com.hyejeanmoon.moonunsplash.domain.scenes.collections.entity.Collections

class CollectionsRecyclerViewAdapter :
    PagedListAdapter<Collections, CollectionsRecyclerViewAdapter.CollectionAdapterViewHolder>(
        diffCallback
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemPhotoBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_photo, parent, false)

        return CollectionAdapterViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: CollectionAdapterViewHolder, position: Int) {
        getItem(position)?.also {
            Glide.with(holder.binding.imgViewPhoto).load(it.coverPhoto?.urls?.regular)
                .into(holder.binding.imgViewPhoto)
        }
    }

    class CollectionAdapterViewHolder(var binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Collections>() {
            override fun areContentsTheSame(oldItem: Collections, newItem: Collections): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areItemsTheSame(oldItem: Collections, newItem: Collections): Boolean {
                return oldItem === newItem
            }
        }
    }

}