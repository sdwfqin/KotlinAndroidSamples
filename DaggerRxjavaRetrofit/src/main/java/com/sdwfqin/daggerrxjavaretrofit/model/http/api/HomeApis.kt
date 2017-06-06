package com.sdwfqin.daggerrxjavaretrofit.model.http.api

import com.sdwfqin.daggerrxjavaretrofit.model.bean.WeatherModel
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by sdwfqin on 2017/5/26.
 */
interface HomeApis {

    /**
     * 测试
     */
    @GET("adat/sk/{cityId}.html")
    fun getMingJia(@Path("cityId") page: String): Flowable<WeatherModel>
}