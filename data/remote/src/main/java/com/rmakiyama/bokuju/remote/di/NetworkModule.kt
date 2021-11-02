package com.rmakiyama.bokuju.remote.di

import com.rmakiyama.bokuju.remote.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.ANDROID
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.header
import javax.inject.Singleton
import kotlinx.serialization.json.Json

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {

    @Provides
    @Singleton
    @SuzuriHttpClient
    internal fun provideHttpClient(): HttpClient {
        return HttpClient(Android) {
            val json = Json { ignoreUnknownKeys = true }
            install(JsonFeature) { serializer = KotlinxSerializer(json) }
            install(Logging) {
                logger = Logger.ANDROID
                if (BuildConfig.DEBUG) level = LogLevel.BODY
            }
            defaultRequest {
                header("Authorization", "Bearer ${BuildConfig.SUZURI_ACCESS_TOKEN}")
            }
        }
    }
}
