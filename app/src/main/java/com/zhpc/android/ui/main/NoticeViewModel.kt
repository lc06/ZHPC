package com.zhpc.android.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.switchMap
import androidx.lifecycle.ViewModel
import com.zhpc.android.logic.Repository
import com.zhpc.android.logic.model.Notice

class NoticeViewModel : ViewModel() {

    private val queryLiveData = MutableLiveData<Any?>()

    val noticeList = ArrayList<Notice>()

    val noticeLiveData = switchMap(queryLiveData) { _ ->
        Repository.queryNotices()
    }

    fun queryNotices() {
        queryLiveData.value = queryLiveData.value
    }

}