package com.zhpc.android.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.zhpc.android.MainActivity
import com.zhpc.android.R
import com.zhpc.android.logic.model.Notice

class NoticeAdapter(private val activity: MainActivity, private val noticeList: List<Notice>) :
    RecyclerView.Adapter<NoticeAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val noticeType: MaterialTextView = view.findViewById(R.id.noticeType)
        val noticeTitle: MaterialTextView = view.findViewById(R.id.noticeTitle)
        val postTime: MaterialTextView = view.findViewById(R.id.postTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notice_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notice = noticeList[position]
        holder.noticeType.text = notice.type
        holder.noticeTitle.text = notice.title
        holder.postTime.text = notice.postTime.toString()
    }

    override fun getItemCount() = noticeList.size
}