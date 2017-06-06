package com.sdwfqin.daggerrxjavaretrofit.model.http

import com.sdwfqin.daggerrxjavaretrofit.model.bean.WeatherModel
import io.reactivex.Flowable


/**
 * Created by sdwfqin on 2017/5/26.
 */
interface HttpHelper {
    fun fetchMingJiaInfo(pages: String): Flowable<WeatherModel>
}