package com.okay.lib

import android.support.annotation.CallSuper
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup

/**
 * Create by zyl
 * @date 2019-09-19
 */
interface IDelegateAdapter<T> {

    /**
     * 是不是需要处理的类型
     */
    fun isForViewType(t: T): Boolean

    /**
     * 创建viewHolder
     */
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    /**
     * 初始化视图
     */
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, t: T?)

    /**
     * 点击事件,外部可选择实现
     * CallSuper 表示强制子类调用super.方法
     */
    @CallSuper
    fun onItemClickListener(view: View, t: T?) {
        Log.d("IDelegateAdapter", "object = ${t.toString()}")
    }

}