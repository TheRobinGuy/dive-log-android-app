package com.example.divelog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.divelog.adapter.LogAdapter
import com.example.divelog.model.Log
import java.sql.Date

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val logRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val logList = mutableListOf<Log>()

        logRecyclerView.layoutManager = LinearLayoutManager(this)
        val logAdapter = LogAdapter(this)
        logRecyclerView.adapter = logAdapter

        val testLog = Log.Builder()
            .id(1)
            .location("Mullaghmore")
            .date(Date(2022,10,6))
            .depth(33.0)
            .time(45)
            .notes("Loads of fish, 10 congers, 2 chased a fish until and dolphin ate them... Then a whale ate him!")
            .build()

        logList.add(testLog)
        logList.add(testLog)
        logList.add(testLog)

        logAdapter.setLogs(logList)
    }
}