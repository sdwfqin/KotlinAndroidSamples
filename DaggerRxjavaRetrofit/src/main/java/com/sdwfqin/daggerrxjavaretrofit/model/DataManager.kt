package com.sdwfqin.daggerrxjavaretrofit.model

import com.sdwfqin.daggerrxjavaretrofit.model.bean.WeatherModel
import com.sdwfqin.daggerrxjavaretrofit.model.http.HttpHelper
import io.reactivex.Flowable

/**
 * Created by sdwfqin on 2017/5/26.
 */
class DataManager(val mHttpHelper: HttpHelper) : HttpHelper {

    override fun fetchMingJiaInfo(pages: String): Flowable<WeatherModel> {
        return mHttpHelper.fetchMingJiaInfo(pages)
    }
}