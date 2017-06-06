package com.sdwfqin.daggerrxjavaretrofit.base

import android.app.Application
import com.sdwfqin.daggerrxjavaretrofit.di.component.AppComponent
import com.sdwfqin.daggerrxjavaretrofit.di.component.DaggerAppComponent
import com.sdwfqin.daggerrxjavaretrofit.di.module.AppModule
import com.sdwfqin.daggerrxjavaretrofit.di.module.HttpModule


/**
 * Created by sdwfqin on 2017/5/26.
 */
class App : Application() {

    // 伴生对象
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .httpModule(HttpModule())
                .build()
    }

}