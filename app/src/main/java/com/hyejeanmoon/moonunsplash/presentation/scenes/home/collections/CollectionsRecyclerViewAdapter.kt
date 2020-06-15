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
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Photo

class CollectionsRecyclerViewAdapter :
    PagedListAdapter<Photo, CollectionsRecyclerViewAdapter.PhotoAdapterViewHolder>(
        diffCallback
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemPhotoBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_photo, parent, false)

        return PhotoAdapterViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: PhotoAdapterViewHolder, position: Int) {
        getItem(position)?.also {
            Glide.with(holder.binding.imgViewPhoto).load(it.urls?.regular)
                .into(holder.binding.imgViewPhoto)
        }
    }

    class PhotoAdapterViewHolder(var binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Photo>() {
            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem.id === newItem.id
            }
        }
    }

}