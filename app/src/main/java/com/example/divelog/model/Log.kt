package com.example.divelog.model

import java.sql.Date

class Log private constructor(
    var id: Int?,
    var location: String?,
    var depth: Double?,
    var time: Int?,
    var notes: String?,
    var buddy: String?, //Make this a class FK
    var date: Date?,
    var diver: String? //Logged in user
){

    data class Builder(
        var id: Int? = null,
        var location: String? = null,
        var depth: Double? = null,
        var time: Int? = null,
        var notes: String? = null,
        var buddy: String? = null, //Make this a class FK
        var date: Date? = null,
        var diver: String? = null //Logged in user
    ){
        fun id(id: Int?) = apply {this.id = id}
        fun location(location: String?) = apply {this.location = location}
        fun depth(depth: Double?) = apply {this.depth = depth}
        fun time(time: Int?) = apply {this.time = time}
        fun notes(notes: String?) = apply {this.notes = notes}
        fun buddy(buddy: String?) = apply {this.buddy = buddy}
        fun date(date: Date?) = apply {this.date = date}
        fun diver(diver: String?) = apply {this.diver = diver}
        fun build() = Log(id, location, depth, time, notes, buddy, date, diver)
    }
}