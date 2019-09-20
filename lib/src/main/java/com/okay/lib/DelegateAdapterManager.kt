package com.okay.lib

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Create by zyl
 * @date 2019-09-19
 */
class DelegateAdapterManager<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * 数据列表
     */
    private var list: MutableList<T>? = null

    /**
     * 存储DelegateAdapter
     */
    private val delegateAdapterList = mutableListOf<IDelegateAdapter<T>>()

    fun update(list: MutableList<T>) {
        if (this.list == null) {
            this.list = mutableListOf()
        }
        this.list?.addAll(list)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        if (list == null) return 0
        return list!!.size
    }

    /**
     * 加委托的adapter
     */
    fun addDelegate(delegateAdapter: IDelegateAdapter<T>) {
        delegateAdapterList.add(delegateAdapter)
    }


    override fun getItemViewType(position: Int): Int {
        val t = list!![position]
        delegateAdapterList.forEach {
            if (it.isForViewType(t)) {
                //把position当初type返回去
                return delegateAdapterList.indexOf(it)
            }
        }
        throw RuntimeException("没有找到可以处理的委托Adapter")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapterList[viewType].onCreateViewHolder(parent, viewType)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = holder.itemViewType
        delegateAdapterList[viewType].onBindViewHolder(holder, list?.get(position))
        holder.itemView.setOnClickListener {
            delegateAdapterList[viewType].onItemClickListener(holder.itemView,list?.get(position))
        }
    }
}