package com.okay.multirecycleitem.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.okay.multirecycleitem.R
import java.util.*

/**
 * Create by zyl
 * @date 2019-09-19
 */
class MyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: MutableList<String>? = null


    fun update(list: ArrayList<String>) {
        if (this.list == null) {
            this.list = mutableListOf()
        }
        this.list!!.addAll(list)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        if (list == null) return 0
        return list!!.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false)
        return MyHolder(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as MyHolder
        holder.textView?.text = list!![position]
    }

    inner class MyHolder : RecyclerView.ViewHolder {

        var textView: TextView? = null

        constructor(itemView: View) : super(itemView) {
            textView = itemView.findViewById<TextView>(R.id.tv)
        }
    }

}