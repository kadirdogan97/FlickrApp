package com.kadirdogan97.flickrapp.ui.recentphotos

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.util.Util
import com.kadirdogan97.flickrapp.R
import com.kadirdogan97.flickrapp.common.Utils
import com.kadirdogan97.flickrapp.common.inflate
import com.kadirdogan97.flickrapp.databinding.PhotoItemBinding
import com.kadirdogan97.flickrapp.model.PhotoItem

/**
 * Created by Kadir Doğan on 7/5/2020.
 */

class RecentListAdapter : RecyclerView.Adapter<RecentListAdapter.RecentListItemViewHolder>() {

    private var recentPhotoList: MutableList<PhotoItem> = mutableListOf()
    lateinit var listener: ItemClickListener
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecentListItemViewHolder {

        val itemBinding = parent.inflate<PhotoItemBinding>(R.layout.photo_item, false)
        return RecentListItemViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = recentPhotoList.size

    override fun onBindViewHolder(holder: RecentListItemViewHolder, position: Int) {
        holder.bind(getRecentPhoto(position))
    }

    private fun getRecentPhoto(position: Int) = recentPhotoList[position]

    fun setRecentPhoto(list: List<PhotoItem>) {
        val beforeSize = recentPhotoList.size
        recentPhotoList.addAll(list)
        notifyItemRangeInserted(beforeSize, list.size)
    }

    inner class RecentListItemViewHolder(private val binding: PhotoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photoItem: PhotoItem) {
            with(binding) {
//                viewState = RecentPhotoItemViewState(photoItem)
                cardView.setOnClickListener {
                    listener.onItemClick(it, Utils.convertPhotoItemToPhotoUrl(photoItem))
                }
                Glide.with(ivProfile.context)
                    .load("${Utils.convertPhotoItemToProfileImageUrl(photoItem)}")
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(ivProfile)
                Glide.with(photo.context)
                    .load("${Utils.convertPhotoItemToPhotoUrl(photoItem)}")
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(photo)
                title.text = photoItem.title
                executePendingBindings()
            }
        }

    }

    interface ItemClickListener {
        fun onItemClick(view: View, photoUrl: String)
    }
}