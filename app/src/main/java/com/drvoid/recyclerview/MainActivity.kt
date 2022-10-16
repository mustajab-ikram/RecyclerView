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

        var todos = mutableListOf(
            Todo("task1", true),
            Todo("task2", true),
            Todo("task3", false),
            Todo("task4", true),
            Todo("task5", false),
            Todo("task6", false),
            Todo("task7", false),
            Todo("task8", true),
            Todo("task9", true),
        )
        val adapter = TodoAdapter(todos)
        val rvTodos = findViewById<RecyclerView>(R.id.rvTodos)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = GridLayoutManager(this, 2)


        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val etTodo = findViewById<EditText>(R.id.etTitle)

        btnAdd.setOnClickListener {
            Log.d("kk", "inside btn click event")

            val title = etTodo.text.toString()
            val todo = Todo(title, false)
            if (etTodo.text == null) {
                Log.d("kk", "inside empty title")
                Toast.makeText(this, "Add something", Toast.LENGTH_LONG).show()
            } else {
                todos.add(todo)
                etTodo.setText("")
            }
            adapter.notifyItemInserted(todos.size - 1)
        }

    }
}