package com.rmakiyama.bokuju.remote.di

import com.rmakiyama.bokuju.remote.suzuri.SuzuriApi
import com.rmakiyama.bokuju.remote.suzuri.SuzuriHttpClient
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RemoteModule {

    @Binds
    @Singleton
    abstract fun provideSuzuriApi(bind: SuzuriHttpClient): SuzuriApi
}
