package com.sdwfqin.daggerrxjavaretrofit.model.bean

/**
 * Created by sdwfqin on 2016/12/7.
 */

data class WeatherModel(var weatherinfo: WeatherinfoBean) {

    companion object {
        data class WeatherinfoBean(var city: String,
                                   var cityid: String,
                                   var temp: String,
                                   var wd: String,
                                   var ws: String,
                                   var sd: String,
                                   var wse: String,
                                   var time: String,
                                   // var isRadar: String,
                                   var radar: String,
                                   var njd: String,
                                   var qy: String)
    }
}
