package com.example.noterecyclerview

import java.util.*

data class Note(
    var title:String,
    var text:String,
    var id:String=UUID.randomUUID().toString(),
) {
}