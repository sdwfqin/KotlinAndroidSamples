package com.sdwfqin.daggerrxjavaretrofit.di.component

import android.app.Activity
import com.sdwfqin.daggerrxjavaretrofit.di.module.ActivityModule
import com.sdwfqin.daggerrxjavaretrofit.di.scope.ActivityScope
import dagger.Component

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    val activity: Activity
}
