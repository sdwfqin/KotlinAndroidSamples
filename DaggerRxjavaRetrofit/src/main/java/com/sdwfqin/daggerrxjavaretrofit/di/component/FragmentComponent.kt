package com.sdwfqin.daggerrxjavaretrofit.di.component

import android.app.Activity
import com.sdwfqin.daggerrxjavaretrofit.di.module.FragmentModule
import com.sdwfqin.daggerrxjavaretrofit.di.scope.FragmentScope
import com.sdwfqin.daggerrxjavaretrofit.view.HomeFragment
import dagger.Component

@FragmentScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    val activity: Activity

    fun inject(homeFragment: HomeFragment)
}
