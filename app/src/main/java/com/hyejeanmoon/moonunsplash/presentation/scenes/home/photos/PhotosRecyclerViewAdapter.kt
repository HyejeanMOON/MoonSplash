package com.hyejeanmoon.moonunsplash.presentation.scenes.home.photos

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

class PhotosRecyclerViewAdapter(
    val callback: (Photo) -> Unit
) :
    PagedListAdapter<Photo, PhotosRecyclerViewAdapter.PhotoAdapterViewHolder>(
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
        getItem(position)?.also { photo ->
            Glide.with(holder.binding.imgViewPhoto).load(photo.urls?.regular)
                .into(holder.binding.imgViewPhoto)

            holder.binding.imgViewPhoto.setOnClickListener {
                callback(photo)
            }
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