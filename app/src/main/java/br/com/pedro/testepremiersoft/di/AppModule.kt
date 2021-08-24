package br.com.pedro.testepremiersoft.di

import android.content.Context
import br.com.pedro.testepremiersoft.data.local.AppDatabase
import br.com.pedro.testepremiersoft.data.local.ArticleDao
import br.com.pedro.testepremiersoft.data.remote.ArticleRemoteDataSource
import br.com.pedro.testepremiersoft.data.remote.ArticleService
import br.com.pedro.testepremiersoft.data.repository.ArticleRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
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
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideArticleService(retrofit: Retrofit): ArticleService =
        retrofit.create(ArticleService::class.java)

    @Singleton
    @Provides
    fun provideArticleRemoteDataSource(service: ArticleService) = ArticleRemoteDataSource(service)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideArticleDao(db: AppDatabase) = db.articleDao()

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: ArticleRemoteDataSource,
        localDataSource: ArticleDao
    ) =
        ArticleRepository(remoteDataSource, localDataSource)
}