package com.okay.multirecycleitem.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.okay.lib.IDelegateAdapter
import com.okay.multirecycleitem.R
import com.okay.multirecycleitem.data.News

/**
 * Create by zyl
 * @date 2019-09-19
 */
class TwoPicDelegateAdapter : IDelegateAdapter<News> {
    override fun isForViewType(t: News): Boolean {
        return t.type == 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_text2, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, t: News?) {
        holder as MyHolder
        holder.textView?.text = t?.desc
    }

    override fun onItemClickListener(view: View, t: News?) {
        super.onItemClickListener(view, t)
        Toast.makeText(view.context,"t = ${t.toString()}",Toast.LENGTH_SHORT).show()
    }

    inner class MyHolder : RecyclerView.ViewHolder {

        var textView: TextView? = null

        constructor(itemView: View) : super(itemView) {
            textView = itemView.findViewById<TextView>(R.id.tv)
        }
    }
}