package com.zhpc.android.logic.network

import com.zhpc.android.logic.model.NoticeResponse
import retrofit2.Call
import retrofit2.http.GET

interface NoticeInitService {
    @GET("post/init")
    fun queryNotices(): Call<NoticeResponse>
}