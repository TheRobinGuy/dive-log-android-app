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
            var logNotes: TextView = view.findViewById(R.id.logTextView)
            var logLocation: TextView = view.findViewById(R.id.logLocationView)
            var logDate: TextView = view.findViewById(R.id.logDateView)
            var logDepth: TextView = view.findViewById(R.id.logDepthView)
            var logTime: TextView = view.findViewById(R.id.logTimeView)
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val logItem: Log = logList[position]
        holder.logNotes.text = String.format("Notes: \n%s", logItem.notes)
        holder.logLocation.text = String.format("Location: %s", logItem.location)
        holder.logDate.text = String.format("Date: %s", logItem.date)
        holder.logDepth.text = String.format("Depth: %sm", logItem.depth)
        holder.logTime.text = String.format("Time: %smins", logItem.time)
    }

    override fun getItemCount(): Int {
        return logList.size
    }

    fun setLogs(logList: List<Log>){
        this.logList = logList
        notifyDataSetChanged()
    }
}