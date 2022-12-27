package com.example.studenthardlife

data class Task(val title: String, val deadline: String, val content: String, val isDone: String) {
    var id: Int = 0

    constructor(id: Int, title: String, deadline: String, content: String, isDone: String) : this(title, deadline, content, isDone) {
        this.id = id
    }
}
