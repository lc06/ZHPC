package com.zhpc.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class ZhpcApplication : Application() {
    companion object {
        //让Android Studio忽略内存泄漏风险提示
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        const val TOKEN = "ebea44a8c6d54183aacf22c9b6254d09"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}