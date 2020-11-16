package com.zhpc.android.logic

import androidx.lifecycle.liveData
import com.zhpc.android.logic.model.Notice
import com.zhpc.android.logic.network.ZhpcNetwork
import kotlinx.coroutines.Dispatchers

object Repository {
    fun queryNotices() = liveData(Dispatchers.IO) {
        val result = try {
            val noticeResponse = ZhpcNetwork.queryNotices()
            if (noticeResponse.status == "success") {
                //处理登录成功逻辑
                val notices = noticeResponse.post
                Result.success(notices)
            } else {
                //处理登录失败逻辑
                Result.failure(RuntimeException("login failed"))
            }
        } catch (e: Exception) {
            Result.failure<List<Notice>>(e)
        }
        emit(result)
    }
}