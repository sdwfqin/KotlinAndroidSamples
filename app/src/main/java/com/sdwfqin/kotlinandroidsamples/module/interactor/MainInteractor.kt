package com.sdwfqin.kotlinandroidsamples.module.interactor

import com.sdwfqin.kotlinandroidsamples.module.ertry.Student

/**
 * Created by sdwfqin on 2017/5/19.
 */
interface MainInteractor {

    open interface OnFinishedListener {
        fun onFinishedSuccess(items: List<Student>)

        fun onFinishedError(s: String)
    }

    fun initData(listener: OnFinishedListener)

    open interface OnMesListener {
        fun onMesSuccess(s: String)

        fun onMesError(s: String)
    }

    fun upData(student: Student, onMesListener: OnMesListener)

    fun delData(student: Student, onMesListener: OnMesListener)

    fun createData(student: Student, onMesListener: OnMesListener)

    fun onDestroy()
}