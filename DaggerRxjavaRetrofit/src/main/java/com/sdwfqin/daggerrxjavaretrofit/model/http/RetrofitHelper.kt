package com.sdwfqin.daggerrxjavaretrofit.model.http

import com.sdwfqin.daggerrxjavaretrofit.model.bean.WeatherModel
import com.sdwfqin.daggerrxjavaretrofit.model.http.api.HomeApis
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by sdwfqin on 2017/5/26.
 */
class RetrofitHelper @Inject constructor(val homeService: HomeApis) : HttpHelper {

    override fun fetchMingJiaInfo(pages: String): Flowable<WeatherModel> {
        return homeService.getMingJia(pages)
    }

}