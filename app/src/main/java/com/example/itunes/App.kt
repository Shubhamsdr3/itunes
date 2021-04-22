package com.example.itunes

import android.app.Application
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.itunes.network.ApiService
import com.example.itunes.util.ReleaseTree
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import timber.log.Timber.DebugTree

class App: Application() {

    companion object {
        private var application: App? = null

        fun getInstance(): App {
            if (application == null) {
                application = App()
            }
            return application!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        application = this
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }

    private fun okHttpClient() =
        OkHttpClient()
            .newBuilder()
            .addInterceptor(ChuckerInterceptor(this)) // for debug only
            .build()

    fun getService(): ApiService {
        val retrofit = Retrofit.Builder()
            .client(okHttpClient())
            .baseUrl(BuildConfig.BASE_URL)
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }

}