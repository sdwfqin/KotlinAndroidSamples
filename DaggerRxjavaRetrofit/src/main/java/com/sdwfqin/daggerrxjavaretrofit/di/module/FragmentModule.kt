package com.sdwfqin.daggerrxjavaretrofit.di.module

import android.app.Activity
import android.support.v4.app.Fragment
import com.sdwfqin.daggerrxjavaretrofit.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @FragmentScope
    fun provideActivity(): Activity {
        return fragment.activity
    }
}
