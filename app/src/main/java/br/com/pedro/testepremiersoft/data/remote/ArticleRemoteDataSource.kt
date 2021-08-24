package br.com.pedro.testepremiersoft.data.remote

import br.com.pedro.testepremiersoft.data.LocalData
import javax.inject.Inject

class ArticleRemoteDataSource @Inject constructor(
    private val service: ArticleService
) : BaseDataSource() {
    suspend fun getArticles() =
        getResult { service.getAllArticles(LocalData().APIKEY, LocalData().country) }
}