package com.sdwfqin.daggerrxjavaretrofit.model.bean

/**
 * Created by sdwfqin on 2016/12/7.
 */

data class WeatherModel(
        var weatherinfo: Weatherinfo
)

data class Weatherinfo(
        var city: String, // 无锡
        var cityid: String, // 101190201
        var temp: String, // 12
        var WD: String, // 西北风
        var WS: String, // 2级
        var SD: String, // 93%
        var WSE: String, // 2
        var time: String, // 10:25
        var njd: String, // 暂无实况
        var qy: String// 1008
)
