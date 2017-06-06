package com.sdwfqin.mvprelam.presenter

import com.sdwfqin.mvprelam.module.ertry.Student
import com.sdwfqin.mvprelam.module.interactor.MainInteractor
import com.sdwfqin.mvprelam.view.MainView
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error


/**
 * constructor：构造方法
 *
 * Created by sdwfqin on 2017/5/19.
 */
class MainPresenterImpl constructor(
        private val mainView: MainView,
        private val mainInteractor: MainInteractor) : MainPresenter, AnkoLogger {

    override fun onResume() {
        error { "onResume" }
        mainView.showProgress()

        mainInteractor.initData(object : MainInteractor.OnFinishedListener {

            override fun onFinishedSuccess(items: List<Student>) {
                mainView.setItems(items)
                mainView.hideProgress()
            }

            override fun onFinishedError(s: String) {
                mainView.showMessage(s)
                mainView.hideProgress()
            }
        })
    }

    override fun OnClickUpData(student: Student, position: Int) {
        mainView.upData(student, position)
    }

    override fun OnClickDelData(student: Student, position: Int) {
        mainInteractor.delData(student, object : MainInteractor.OnMesListener {
            override fun onMesSuccess(s: String) {
                mainView.upAdapter(position)
                mainView.showMessage(s)
            }

            override fun onMesError(s: String) {
                mainView.showMessage(s)
            }
        })
    }

    override fun OnUpData(student: Student, position: Int) {
        mainInteractor.upData(student, object : MainInteractor.OnMesListener {
            override fun onMesSuccess(s: String) {
                mainView.upAdapter(student, position)
                mainView.showMessage(s)
            }

            override fun onMesError(s: String) {
                mainView.showMessage(s)
            }
        })
    }

    override fun OnCreateData(student: Student) {
        mainInteractor.createData(student, object : MainInteractor.OnMesListener {
            override fun onMesSuccess(s: String) {
                mainView.addAdapter(student)
                mainView.showMessage(s)
            }

            override fun onMesError(s: String) {
                mainView.showMessage(s)
            }
        })
    }

    override fun createData() {
        mainView.showBottomSheetDialog()
    }

    override fun onDestroy() {
        mainInteractor.onDestroy()
    }
}