package com.drvoid.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

var change = 3
class TodoAdapter (
    val todos: List<Todo>
        ) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
         change--
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        if(change == 0) {
            change = 3
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_not_do, parent, false)
        }
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply {
            val tvTitle = findViewById<TextView>(R.id.tvTitle)
            val cbDone = findViewById<CheckBox>(R.id.cbDone)
            val tvTitle2 = findViewById<TextView>(R.id.tvNotDo)
            val cbDone2 = findViewById<CheckBox>(R.id.cbNotDone)
            if(position % 3 == 0) {
                tvTitle2.text = todos[position].title
                cbDone2.isChecked = todos[position].isChecked
            } else {
                tvTitle.text = todos[position].title
                cbDone.isChecked = todos[position].isChecked
            }
        }


    }

    override fun getItemCount(): Int {
        return todos.size
    }
}