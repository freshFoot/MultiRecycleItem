package com.okay.multirecycleitem

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.okay.lib.DelegateAdapterManager
import com.okay.multirecycleitem.adapter.OnePicDelegateAdapter
import com.okay.multirecycleitem.adapter.TwoPicDelegateAdapter
import com.okay.multirecycleitem.data.News
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    //    private val list = Data.getList()
    private val list = mutableListOf<News>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleView.layoutManager = LinearLayoutManager(this)
//        val myAdapter = MyAdapter()
        val myAdapter = DelegateAdapterManager<News>()

        recycleView.adapter = myAdapter

        myAdapter.addDelegate(OnePicDelegateAdapter())
        myAdapter.addDelegate(TwoPicDelegateAdapter())

        for (i in 0..20) {
            val news = News()
            if (i == 2) {
                news.type = 1
            }
            news.desc = "$i = 北京时间9月19日凌晨2时，美联储宣布下调联邦基金利率25个基点至1.75%-2.00%。这是2008年12月以来美联储的第二次降息。"
            list.add(news)
        }

        myAdapter.update(list)
    }
}
