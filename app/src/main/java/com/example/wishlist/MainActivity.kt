package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wishlist.databinding.ActivityMainBinding as WishlistActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: WishlistActivityMainBinding
    private lateinit var wishListViewModel: WishlistModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = WishlistActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        wishListViewModel = ViewModelProvider(this)[WishlistModel::class.java]

        binding.submitButton.setOnClickListener {
            val name = binding.wishName.text.toString()
            val price = binding.wishPrice.text.toString()
            val url = binding.wishUrl.text.toString()
            val newWish = WishlistItem(name, price, url)
            binding.wishName.text.clear()
            binding.wishPrice.text.clear()
            binding.wishUrl.text.clear()
            wishListViewModel.addWishListItem(newWish)
        }
        setRecyclerView()
    }

    private fun setRecyclerView()
    {
        wishListViewModel.wishList.observe(this){
            binding.rvWishList.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = WishlistAdapter(it)
            }
        }
    }
}