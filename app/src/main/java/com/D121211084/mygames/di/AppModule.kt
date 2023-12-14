package com.D121211084.mygames.di

import com.D121211084.mygames.BuildConfig
import com.D121211084.mygames.data.source.GamesRepository
import com.D121211084.mygames.data.source.GamesRepositoryImpl
import com.D121211084.mygames.data.source.remote.RemoteDataSource
import com.D121211084.mygames.data.source.remote.web.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return if (BuildConfig.DEBUG) {
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
        } else {
            OkHttpClient.Builder()
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
        }
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

//    @Provides
//    @Singleton
//    fun provideGameDatabase(@ApplicationContext context: Context): GameDatabase {
//        return Room.databaseBuilder(
//            context.applicationContext,
//            GameDatabase::class.java,
//            "game_database"
//        ).fallbackToDestructiveMigration()
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideLocalDataSource(gameDatabase: GameDatabase): LocalDataSource = LocalDataSourceImpl(gameDatabase)

    @Provides
    @Singleton
    fun provideRepository(remoteDataSource: RemoteDataSource): GamesRepository {
        return GamesRepositoryImpl(remoteDataSource)
    }

}