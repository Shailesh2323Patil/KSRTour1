package com.example.kesaritours.di

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import com.example.kesaritours.data.local.database.DataBase
import com.example.kesaritours.data.local.util.Converters
import com.example.kesaritours.data.local.util.GsonParser
import com.example.kesaritours.data.local.util.JsonParser
import com.example.kesaritours.data.remote.ToursApi
import com.example.kesaritours.data.repository.ToursInfoRepositoryImpl
import com.example.kesaritours.domain.repository.ToursInfoRepository
import com.example.kesaritours.util.Constants
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ToursInfoModule {

    @Provides
    @Singleton
    fun okHttpClient() : OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addNetworkInterceptor(httpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideToursApi(okHttpClient: OkHttpClient) : ToursApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ToursApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDataBase(application: Application) : DataBase {
        return Room.databaseBuilder(
            application,
            DataBase::class.java,
            Constants.DATABASE_NAME
        ).addTypeConverter(Converters(GsonParser(Gson()))).build()
    }

    @Provides
    @Singleton
    fun provideToursInfoRepository(
        database: DataBase ,
        api: ToursApi
    ) : ToursInfoRepository {
        return ToursInfoRepositoryImpl(api = api, dao = database.toursDao)
    }
}