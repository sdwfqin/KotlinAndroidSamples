package com.sdwfqin.kotlinandroidsamples.module.ertry

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by sdwfqin on 2016/12/13.
 */
open class Student(
        @PrimaryKey var id: Long = 0,
        var name: String? = "",
        var sex: String? = "",
        var address: String? = "") : RealmObject() {

    override fun toString(): String {
        return "Student(id=$id, name=$name, sex=$sex, address=$address)"
    }
}
