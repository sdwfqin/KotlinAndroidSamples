package com.sdwfqin.daggerrxjavaretrofit.di.component

import com.sdwfqin.daggerrxjavaretrofit.base.App
import com.sdwfqin.daggerrxjavaretrofit.di.module.AppModule
import com.sdwfqin.daggerrxjavaretrofit.di.module.HttpModule
import com.sdwfqin.daggerrxjavaretrofit.model.DataManager
import com.sdwfqin.daggerrxjavaretrofit.model.http.RetrofitHelper
import dagger.Component
import javax.inject.Singleton


/**
 * Created by sdwfqin on 2017/5/26.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, HttpModule::class))
interface AppComponent {

    fun getContext(): App   // 提供App的Context

    fun getDataManager(): DataManager  //数据中心

    fun retrofitHelper(): RetrofitHelper   //提供http的帮助类

}
