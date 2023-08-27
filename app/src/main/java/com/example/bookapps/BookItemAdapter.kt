package com.example.bookapps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookItemAdapter (
    private val context: Context,
    private val books : List<Book>,
    val listener : (Book) -> Unit
) : RecyclerView.Adapter<BookItemAdapter.BookViewHolder>(){
    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imageSrc = view.findViewById<ImageView>(R.id.imgbook)
        val title = view.findViewById<TextView>(R.id.namabook)
        val author = view.findViewById<TextView>(R.id.authorbook)
        fun bindView(book: Book,listener: (Book) -> Unit){
            imageSrc.setImageResource(book.imageSrc)
            title.text = book.imTitle
            author.text = book.imAuthor
            itemView.setOnClickListener { listener(book) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder
    = BookViewHolder(LayoutInflater.from(context).inflate(R.layout.book_item,parent,false))

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bindView(books[position],listener)
    }
}