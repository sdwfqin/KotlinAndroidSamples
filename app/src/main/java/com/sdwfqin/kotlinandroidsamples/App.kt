package com.sdwfqin.kotlinandroidsamples

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration


/**
 * Created by sdwfqin on 2017/5/20.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val config = RealmConfiguration.Builder()
                .name("Student.realm")
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(config)
    }
}
