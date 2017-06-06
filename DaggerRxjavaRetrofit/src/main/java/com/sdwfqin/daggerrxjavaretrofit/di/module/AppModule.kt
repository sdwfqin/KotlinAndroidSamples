package com.sdwfqin.daggerrxjavaretrofit.di.module

import com.sdwfqin.daggerrxjavaretrofit.base.App
import com.sdwfqin.daggerrxjavaretrofit.model.DataManager
import com.sdwfqin.daggerrxjavaretrofit.model.http.HttpHelper
import com.sdwfqin.daggerrxjavaretrofit.model.http.RetrofitHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by sdwfqin on 2017/5/26.
 */
@Module
class AppModule constructor(val application:App) {

    @Provides
    @Singleton
    fun provideApplicationContext(): App {
        return application
    }

    @Provides
    @Singleton
    fun provideHttpHelper(retrofitHelper: RetrofitHelper): HttpHelper {
        return retrofitHelper
    }

    @Provides
    @Singleton
    fun provideDataManager(httpHelper: HttpHelper): DataManager {
        return DataManager(httpHelper)
    }
}