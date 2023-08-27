package com.example.bookapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvBook: RecyclerView
    private val list = ArrayList<Book>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    private fun getListBooks(): ArrayList<Book> {
        val listBook = ArrayList<Book>()
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataTitle = resources.getStringArray(R.array.data_Title)
        val dataAuthor = resources.getStringArray(R.array.data_Writer)
        val dataDescription = resources.getStringArray(R.array.data_description)

        for (i in dataTitle.indices) {
            val book = Book(
                dataPhoto.getResourceId(i, -1),
                dataTitle[i],
                dataAuthor[i],
                dataDescription[i]
            )
            listBook.add(book)
        }
        dataPhoto.recycle()
        return listBook
    }

    private fun showRecyclerList() {
        rvBook.layoutManager = LinearLayoutManager(this)
        val listBookAdapter = ListBookAdapter(list)
        rvBook.adapter = listBookAdapter

        listBookAdapter.setOnItemClickCallback(object : ListBookAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Book) {
                showSelectedBook(data)
            }
        })
    }

    private fun showSelectedHero(book: Book) {
        val moveData = Intent(this@MainActivity, DetailActivity::class.java)
        moveData.putExtra(DetailActivity.BOOK_PHOTO, book.imageSrc)
        moveData.putExtra(DetailActivity.BOOK_TITLE, book.imTitle)
        moveData.putExtra(DetailActivity.BOOK_AUTHOR, book.imAuthor)
        moveData.putExtra(DetailActivity.BOOK_DESCRIPTION, book.description)
        startActivity(moveData)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}