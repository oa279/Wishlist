package com.example.wishlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.databinding.WishlistItemsBinding

class WishlistAdapter(
    private val wishes: MutableList<WishlistItem>,
) : RecyclerView.Adapter<WishlistItemViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistItemViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val wishView = WishlistItemsBinding.inflate(inflater, parent, false)
        return WishlistItemViewHolder(context, wishView)
    }
    override fun onBindViewHolder(holder: WishlistItemViewHolder, position: Int) {
        holder.bindWishListItem(wishes[position])
    }

    override fun getItemCount(): Int = wishes.size
}

