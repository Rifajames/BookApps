package com.example.bookapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListBookAdapter(private val listBook: ArrayList<Book>) :
    RecyclerView.Adapter<ListBookAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.imgbook)
        val bookName: TextView = itemView.findViewById(R.id.namabook)
        val bookAuthor: TextView = itemView.findViewById(R.id.authorbook)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListBookAdapter.ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListBookAdapter.ListViewHolder, position: Int) {
        val (src, title, author, description) = listBook[position]
        holder.imgPhoto.setImageResource(src)
        holder.bookName.text = title
        holder.bookAuthor.text = author
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listBook[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listBook.size

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }
}