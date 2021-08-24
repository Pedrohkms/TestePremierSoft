package br.com.pedro.testepremiersoft.data.remote

import br.com.pedro.testepremiersoft.data.LocalData
import br.com.pedro.testepremiersoft.data.entities.Article
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {

    @GET("top-headlines")
    suspend fun getAllArticles(
        @Query("apiKey") apiKey: String = LocalData().APIKEY,
        @Query("country") coutry: String = LocalData().country
    ): Response<List<Article>>
}