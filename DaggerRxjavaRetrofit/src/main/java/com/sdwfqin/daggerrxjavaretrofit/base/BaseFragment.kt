package com.sdwfqin.daggerrxjavaretrofit.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sdwfqin.daggerrxjavaretrofit.di.component.DaggerFragmentComponent
import com.sdwfqin.daggerrxjavaretrofit.di.component.FragmentComponent
import com.sdwfqin.daggerrxjavaretrofit.di.module.FragmentModule
import org.jetbrains.anko.AnkoLogger


/**
 * Created by sdwfqin on 2017/5/25.
 */
abstract class BaseFragment : Fragment(), AnkoLogger {

    protected lateinit var mView: View

    protected fun getFragmentComponent(): FragmentComponent {
        return DaggerFragmentComponent
                .builder()
                .appComponent(App.appComponent)
                .fragmentModule(FragmentModule(this))
                .build()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mView = inflater!!.inflate(getLayoutId(), container, false)
        return mView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInject()
        initEventAndData()
    }

    protected abstract fun getLayoutId(): Int
    protected abstract fun initEventAndData()
    protected abstract fun initInject()
}