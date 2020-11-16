package com.zhpc.android

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.heweather.plugin.view.HeContent
import com.heweather.plugin.view.HeWeatherConfig
import com.zhpc.android.ui.main.NoticeAdapter
import com.zhpc.android.ui.main.NoticeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.weather_right_large.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this).get(NoticeViewModel::class.java) }

    private lateinit var adapter: NoticeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        HeWeatherConfig.init("f354c993bfc24d5d9e8036a11b1b9925", "CN101190801")
        setupWeatherPlugin()
        val layoutManager = LinearLayoutManager(this)
        noticeRecyclerView.layoutManager = layoutManager
        adapter = NoticeAdapter(this, viewModel.noticeList)
        noticeRecyclerView.adapter = adapter
        viewModel.queryNotices()
        viewModel.noticeLiveData.observe(this, Observer { result ->
            val notices = result.getOrNull()
            if (notices != null) {
                viewModel.noticeList.clear()
                viewModel.noticeList.addAll(notices)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "未能查询到任何系统公告", Toast.LENGTH_SHORT).show()
                result.exceptionOrNull()?.printStackTrace()
            }
        })
    }

    private fun setupWeatherPlugin() {

        val rightLayout: LinearLayout = rlView.rightLayout
        val leftTopLayout: LinearLayout = rlView.leftTopLayout
        val leftBottomLayout: LinearLayout = rlView.leftBottomLayout
        //rlView.setDefaultBack(false);
        rlView.setStroke(0, Color.GRAY, 1, Color.WHITE)
        rlView.addLocation(leftTopLayout, 14, Color.WHITE)
        rlView.addAqiText(leftTopLayout, 14)
        rlView.addAqiQlty(leftTopLayout, 14)
        rlView.addAqiNum(leftTopLayout, 14)
        rlView.addAlarmIcon(leftTopLayout, 14)
        rlView.addAlarmTxt(leftTopLayout, 14)
        rlView.addWeatherIcon(leftTopLayout, 14)

        rlView.addRainIcon(leftBottomLayout, 14)
        rlView.addRainDetail(leftBottomLayout, 14, Color.WHITE)
        rlView.addWindIcon(leftBottomLayout, 14)
        rlView.addWind(leftBottomLayout, 14, Color.WHITE)
        rlView.addCond(leftBottomLayout, 14, Color.WHITE)

        rlView.addTemp(rightLayout, 40, Color.WHITE)
        rlView.setViewGravity(HeContent.GRAVITY_CENTER)
        rlView.show()

    }

}