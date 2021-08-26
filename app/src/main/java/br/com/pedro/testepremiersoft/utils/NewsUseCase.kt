package br.com.pedro.testepremiersoft.utils

import br.com.pedro.testepremiersoft.data.model.NewsDetails
import br.com.pedro.testepremiersoft.data.repository.NewsRepository
import io.reactivex.Observable

interface NewsUseCaseInterface {
    fun execute(): Observable<List<NewsDetails>>
}

class NewsUseCase(private val repository: NewsRepository) :
    NewsUseCaseInterface {
    override fun execute(): Observable<List<NewsDetails>> {
        return repository.getNews()
            .map { it.articles }
    }
}