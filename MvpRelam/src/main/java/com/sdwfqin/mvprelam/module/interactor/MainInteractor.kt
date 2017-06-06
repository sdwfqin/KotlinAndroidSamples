package com.sdwfqin.mvprelam.module.interactor

import com.sdwfqin.mvprelam.module.ertry.Student

/**
 * Created by sdwfqin on 2017/5/19.
 */
interface MainInteractor {

    interface OnFinishedListener {
        fun onFinishedSuccess(items: List<Student>)

        fun onFinishedError(s: String)
    }

    fun initData(listener: OnFinishedListener)

    interface OnMesListener {
        fun onMesSuccess(s: String)

        fun onMesError(s: String)
    }

    fun upData(student: Student, onMesListener: OnMesListener)

    fun delData(student: Student, onMesListener: OnMesListener)

    fun createData(student: Student, onMesListener: OnMesListener)

    fun onDestroy()
}