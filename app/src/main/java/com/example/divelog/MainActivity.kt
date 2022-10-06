package com.example.divelog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.divelog.adapter.LogAdapter
import com.example.divelog.model.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.sql.Date

class MainActivity : AppCompatActivity(), DialogClosedListener {

    private lateinit var logAdapter: LogAdapter
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val logRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val logList = mutableListOf<Log>()

        logRecyclerView.layoutManager = LinearLayoutManager(this)
        logAdapter = LogAdapter(this)
        logRecyclerView.adapter = logAdapter

        floatingActionButton = findViewById(R.id.floatingActionButton)

        val clickListener = View.OnClickListener{
            AddNewLog.newInstance().show(supportFragmentManager, AddNewLog.TAG)
        }

        floatingActionButton.setOnClickListener(clickListener)

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

    override fun handleDialogClose(dialog: DialogInterface) {
        logAdapter.notifyDataSetChanged()
    }
}