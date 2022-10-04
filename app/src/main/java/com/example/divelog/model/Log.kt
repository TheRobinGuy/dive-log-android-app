package com.example.divelog.model

import java.sql.Date

class Log {
    private val id: Int = 0
    private val location: String = ""
    private val depth: Double = 0.0
    private val time: Int = 0
    private val notes: String = ""
    private val buddy: String = "" //Make this a class FK
    private val date: Date = Date(1900,1,1)
    private val diver: String = "" //Logged in user
}