package com.example.lovecalculator.di

import android.content.Context
import android.content.SharedPreferences
import android.provider.SyncStateContract
import com.example.lovecalculator.network.LoveApi
import com.google.android.gms.cast.framework.SessionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    fun provideApi():LoveApi{
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }
    @Provides
    fun providePreferences(@ApplicationContext context: Context):SharedPreferences{
      return context.getSharedPreferences("settings",Context.MODE_PRIVATE)
    }



}
