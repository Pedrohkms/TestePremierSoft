package br.com.pedro.testepremiersoft.data.repository

import br.com.pedro.testepremiersoft.data.api.Api
import br.com.pedro.testepremiersoft.data.model.NewsModel
import io.reactivex.Observable


class NewsRepository(private val api: Api) : NewsInterface {
    override fun getNews(): Observable<NewsModel> {
        return api.getNews()
    }
}

interface NewsInterface {
    fun getNews(): Observable<NewsModel>
}


