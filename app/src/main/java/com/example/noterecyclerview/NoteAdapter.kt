package com.example.noterecyclerview

import android.database.sqlite.SQLiteDatabase
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter (var todoList:List<Note>,private var delete: ((note:Note) -> Unit)):RecyclerView.Adapter<viewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val item=LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return viewHolder(item)
    }
    override fun onBindViewHolder(holder: viewHolder, position: Int){
         holder.itemView.findViewById<TextView>(R.id.titleRecycler).text = todoList[position].title
        holder.itemView.findViewById<TextView>(R.id.noteRecycler).text = todoList[position].text
        holder.itemView.findViewById<ImageButton>(R.id.trashButton).setOnClickListener {
              delete(todoList[position])
        }
    }
    override fun getItemCount(): Int {
        return todoList.size
    }


}
class viewHolder(itemView: View):RecyclerView.ViewHolder(itemView){


}
