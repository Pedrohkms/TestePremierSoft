package br.com.pedro.testepremiersoft.data.api

import br.com.pedro.testepremiersoft.data.LocalData
import br.com.pedro.testepremiersoft.data.model.NewsModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("top-headlines")
    fun getNews(
        @Query("country") coutry: String = LocalData().country,
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") apiKey: String = LocalData().APIKEY
    ): Observable<NewsModel>
}