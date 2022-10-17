package com.drvoid.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf(
            Todo("Task1", true),
            Todo("Task2", true),
            Todo("Task3", true),
            Todo("Task4", false),
            Todo("Task5", true),
            Todo("Task6", false),
            Todo("Task7", true),
            Todo("Task8", false),
            Todo("Task9", true)
        )
        val adapter = TodoAdapter(todoList)
        val rvTodos = findViewById<RecyclerView>(R.id.rvTodo)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)
    }
}