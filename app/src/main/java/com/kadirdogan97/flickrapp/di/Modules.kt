package com.kadirdogan97.flickrapp.di

import android.content.Context
import com.kadirdogan97.flickrapp.data.FlickrRepository
import com.kadirdogan97.flickrapp.data.remote.FlickrApiRestInterface
import com.kadirdogan97.flickrapp.data.remote.FlickrRemoteDataSource
import com.kadirdogan97.flickrapp.ui.VMMain
import com.kadirdogan97.flickrapp.ui.recentphotos.RecentListMapper
import com.kadirdogan97.flickrapp.ui.recentphotos.RecentListUseCase
import com.kadirdogan97.flickrapp.ui.recentphotos.VMRecentList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by Kadir Doğan on 7/5/2020.
 */

val networkModules = module{
    fun provideOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).setLevel(
            HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://www.flickr.com/services/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun provideRestInterface(retrofit: Retrofit): FlickrApiRestInterface {
        return retrofit.create()
    }

    single {provideOkHttpClient()}
    single { provideRetrofit(okHttpClient = get()) }
    single { provideRestInterface(retrofit = get()) }
}

val dataSourceModules = module {
    single<FlickrRemoteDataSource> { FlickrRemoteDataSource(restInterface = get()) }
}
val repositoryModules = module{
    single<FlickrRepository>{
        FlickrRepository(remoteDataSource = get())
    }
}
val useCaseModules = module{
    factory{
        RecentListMapper()
    }
    single{
        RecentListUseCase(
            repository = get(),
            mapper = get()
        )
    }
}
val viewModelModules = module {
    viewModel{
        VMRecentList(
            recentListUseCase = get()
        )
    }
    viewModel {
        VMMain()
    }
}
