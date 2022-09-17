package com.example.noterecyclerview

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.strictmode.SqliteObjectLeakedViolation
import android.provider.ContactsContract
import android.widget.TextView
import android.widget.Toast
import com.example.noterecyclerview.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var todoList = mutableListOf<Note>(
        Note("title1", "text1"),
        Note("title2", "text2"),
        Note("title3", "text2")
    )

    private var noteAdapter = NoteAdapter(todoList, delete = { noteDelete(it) })


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.todoRecyclerView.adapter = noteAdapter


            binding.addButton.setOnClickListener {
                var title=binding.title.text.toString()
                var content=binding.content.text.toString()
                if(title.isEmpty()){
                    Toast.makeText(this, "Add title please", Toast.LENGTH_SHORT).show()
                }
                if(content.isEmpty()){
                    Toast.makeText(this, "Add content please", Toast.LENGTH_SHORT).show()
                }
                if(title.isNotEmpty() && content.isNotEmpty()){
                    addNote(title,content)
                }
            }
    }

    private fun noteDelete(note: Note) {
        todoList.remove(note)
        noteAdapter.notifyDataSetChanged()
    }

    private fun addNote( title:String, content:String) {
        val newTodo = Note(title, content)
        todoList.add(newTodo)
        noteAdapter.notifyDataSetChanged()
    }


}