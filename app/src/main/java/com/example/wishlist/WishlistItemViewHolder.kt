package com.example.wishlist

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.databinding.WishlistItemsBinding

class WishlistItemViewHolder(
    private val context: Context,
    private val binding: WishlistItemsBinding
): RecyclerView.ViewHolder(binding.root)
{
    fun bindWishListItem(wish: WishlistItem)
    {
        binding.nameItem.text = wish.name
        binding.priceItem.text = wish.price
        binding.urlItem.text = wish.url
    }
}
