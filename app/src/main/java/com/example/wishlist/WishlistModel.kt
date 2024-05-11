package com.example.wishlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WishlistModel: ViewModel()
{
    var wishList = MutableLiveData<MutableList<WishlistItem>>()

    init {
        wishList.value = mutableListOf()
    }
    fun addWishListItem(wishListItem: WishlistItem)
    {
        wishList.value?.add(wishListItem)
        val list = wishList.value
        wishList.postValue(list)
    }
}
