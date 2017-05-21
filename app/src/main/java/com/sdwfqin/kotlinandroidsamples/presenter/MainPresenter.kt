package com.sdwfqin.kotlinandroidsamples.presenter

import com.sdwfqin.kotlinandroidsamples.module.ertry.Student

/**
 * Created by sdwfqin on 2017/5/19.
 */
interface MainPresenter {

    fun onResume()

    fun OnClickUpData(student: Student, position: Int)

    fun OnClickDelData(student: Student, position: Int)

    fun OnUpData(student: Student, position: Int)

    fun OnCreateData(student: Student)

    fun createData()

    fun onDestroy()
}