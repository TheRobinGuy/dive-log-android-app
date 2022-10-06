package com.example.divelog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.divelog.MainActivity
import com.example.divelog.R
import com.example.divelog.model.Log

class LogAdapter(activity: MainActivity) : Adapter<LogAdapter.ViewHolder>() {

    private lateinit var logList: List<Log>
    private var mainActivity: MainActivity = activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.log_layout, parent, false)
        return LogAdapter.ViewHolder(itemView)
    }

    class ViewHolder constructor(view: View): RecyclerView.ViewHolder(view) {
            var log: TextView = view.findViewById(R.id.logTextView)
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val logItem: Log = logList[position]
        holder.log.setText(String.format("Location: %s \t Date: %s", logItem.location, logItem.date))
    }

    override fun getItemCount(): Int {
        return logList.size
    }

    fun setLogs(logList: List<Log>){
        this.logList = logList
        notifyDataSetChanged()
    }
}