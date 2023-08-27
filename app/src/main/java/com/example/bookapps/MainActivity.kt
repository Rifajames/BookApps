package com.example.bookapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE ="OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BookList = listOf<Book>(
            Book(R.drawable.gof,"Design Patterns: Elements of Reusable Object-Oriented Software","Erich Gamma, John Vlissides, Richard Helm, Ralph Johnson","Design Patterns: Elements of Reusable Object-Oriented Software is a software engineering book describing software design patterns. The book was written by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides, with a foreword by Grady Booch."),
            Book(R.drawable.java,"Java Programming","Joyce Farrell","Discover the power of Java for developing applications with the engaging, hands-on approach in Farrell's JAVA PROGRAMMING, 8E. With this book, even first-time programmers can quickly develop useful programs while learning the basic principles of structured and object-oriented programming"),
            Book(R.drawable.javascript,"Learning JavaScript Design Patterns","Addy Osmani","With Learning JavaScript Design Patterns, you’ll learn how to write beautiful, structured, and maintainable JavaScript by applying classical and modern design patterns to the language"),
            Book(R.drawable.dbdesign,"Database Design for Mere Mortals: A Hands-on Guide to Relational Database Design","Michael J. Hernandez","Database Design for Mere Mortals™, Second Edition, is a straightforward, platform-independent tutorial on the basic principles of relational database design. It provides a commonsense design methodology for developing databases that work"),
            Book(R.drawable.sql,"The art of SQL","Stéphane Faroult","For all the buzz about trendy IT techniques, data processing is still at the core of our systems, especially now that enterprises all over the world are confronted with exploding volumes of data"),
            Book(R.drawable.dbsystem,"Fundamentals of Database Systems","Ramez Elmasri","Basic concepts; Databases and database users; Database system concepts and architecture; Data modeling using the entity-relationship approach; Record storage and primary file organizations; Index"),
            Book(R.drawable.progkotlin,"Programming Kotlin: Create Elegant, Expressive, and Performant JVM and Android Applications","Venkat Subramaniam","Kotlin is a highly concise, elegant, fluent, and expressive statically typed multi-paradigm language."),
            Book(R.drawable.androkotlin,"Android Development with Kotlin","Marcin Moskala, Igor Wojda","Learn how to make Android development much faster using a variety of Kotlin features, from basics to advanced, to write better quality code.About This BookLeverage specific features of Kotlin to ease"),
            Book(R.drawable.swift,"IOS 10 Programming Fundamentals with Swift: Swift, Xcode, and Cocoa Basics","Matt Neuburg","If you're grounded in the basics of Swift, Xcode, and the Cocoa framework, this book provides a structured explanation of all essential real-world iOS app components. Through deep exploration and copious code examples, you'll learn how to create views, manipulate view controllers, and add features from iOS frameworks."),
            Book(R.drawable.html,"HTML & CSS: Design and Build Web Sites","Jon Duckett","A full-color introduction to the basics of HTML and CSS from the publishers of Wrox!  Every day, more and more people want to learn some HTML and CSS")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = BookItemAdapter(this,BookList){
            val intent = Intent(this,DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.profile -> {
                val moveIntent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
}