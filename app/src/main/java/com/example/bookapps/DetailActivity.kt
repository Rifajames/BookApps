package com.example.bookapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bookapps.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val photo = intent.getIntExtra(BOOK_PHOTO, 0)
        val title = intent.getStringExtra(BOOK_TITLE)
        val author = intent.getStringExtra(BOOK_AUTHOR)
        val description = intent.getStringExtra(BOOK_DESCRIPTION)

        binding.bookPhoto.setImageResource(photo)
        binding.bookNama.text = title
        binding.bookAuthor.text = author
        binding.bookDesc.text = description
    }

    companion object{
        const val BOOK_PHOTO = "book_photo"
        const val BOOK_TITLE = "book_title"
        const val BOOK_AUTHOR = "book_author"
        const val BOOK_DESCRIPTION = "book_description"
    }
}