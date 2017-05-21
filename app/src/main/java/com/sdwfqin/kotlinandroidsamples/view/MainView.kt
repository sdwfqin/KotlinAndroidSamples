package com.sdwfqin.kotlinandroidsamples.view

import com.sdwfqin.kotlinandroidsamples.module.ertry.Student

/**
 * Created by sdwfqin on 2017/5/19.
 */
interface MainView {

    /**
     * 显示进度条
     */
    fun showProgress()

    /**
     * 取消进度条
     */
    fun hideProgress()

    /**
     * 悬浮按钮
     */
    fun showBottomSheetDialog()

    /**
     * 刷新数据
     */
    fun upData(student: Student, position: Int)

    /**
     * 刷新Adapter
     */
    fun upAdapter(student: Student, position: Int)

    /**
     * 刷新Adapter
     */
    fun upAdapter(position: Int)

    /**
     * 添加数据到Adapter
     */
    fun addAdapter(student: Student)

    /**
     * 显示Toast消息
     */
    fun showMessage(message: String)

    /**
     * 设置数据
     */
    fun setItems(items: List<Student>)
}