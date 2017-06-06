package com.sdwfqin.daggerrxjavaretrofit.di.module

import com.sdwfqin.daggerrxjavaretrofit.di.qualifier.HomeUrl
import com.sdwfqin.daggerrxjavaretrofit.model.http.api.BaseUrl
import com.sdwfqin.daggerrxjavaretrofit.model.http.api.HomeApis
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


/**
 * Created by sdwfqin on 2017/5/26.
 */
@Module
class HttpModule {

    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
    }

    @Singleton
    @Provides
    @HomeUrl
    fun provideHomeRetrofit(builder: Retrofit.Builder): Retrofit {
        return createRetrofit(builder, BaseUrl.Home)
    }

    @Singleton
    @Provides
    fun provideHomeService(@HomeUrl retrofit: Retrofit): HomeApis {
        return retrofit.create<HomeApis>(HomeApis::class.java)
    }

    fun createRetrofit(builder: Retrofit.Builder, url: String): Retrofit {
        return builder
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}