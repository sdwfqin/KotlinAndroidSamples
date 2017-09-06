package com.sdwfqin.daggerrxjavaretrofit.view

import com.sdwfqin.daggerrxjavaretrofit.R
import com.sdwfqin.daggerrxjavaretrofit.base.BaseFragment
import com.sdwfqin.daggerrxjavaretrofit.model.DataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.info
import javax.inject.Inject

/**
 * Created by sdwfqin on 2017/5/25.
 */
class HomeFragment : BaseFragment() {

    @Inject
    lateinit var mDataManager: DataManager

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initInject() {
        getFragmentComponent().inject(this)
    }


    override fun initEventAndData() {
        mDataManager.fetchMingJiaInfo("101190201")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { s ->
                    info { s }
                    home_tv.text = s.weatherinfo.toString()
                }
    }
}
