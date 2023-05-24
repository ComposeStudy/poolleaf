package com.poolleaf.composestudy.frog.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.poolleaf.composestudy.frog.data.repository.FrogRepository
import com.poolleaf.composestudy.frog.data.repository.impl.FrogRepositoryImpl
import com.poolleaf.composestudy.frog.data.service.FrogService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindFrogRepository(
        frogRepository: FrogRepositoryImpl
    ): FrogRepository

    companion object {
        @OptIn(ExperimentalSerializationApi::class)
        @Provides
        @ViewModelScoped
        fun provideFrogService(): FrogService = Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl("https://android-kotlin-fun-mars-server.appspot.com")
            .build()
            .create(FrogService::class.java)
    }
}

