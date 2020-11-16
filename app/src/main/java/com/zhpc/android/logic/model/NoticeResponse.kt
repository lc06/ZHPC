package com.zhpc.android.logic.model

data class NoticeResponse(val status: String, val post: List<Notice>)

data class Notice(
    val post_id: Int,
    val title: String,
    val content: String,
    val type: String,
    val postTime: Int
)
