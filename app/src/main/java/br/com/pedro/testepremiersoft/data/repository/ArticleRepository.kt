package br.com.pedro.testepremiersoft.data.repository

import br.com.pedro.testepremiersoft.data.local.ArticleDao
import br.com.pedro.testepremiersoft.data.remote.ArticleRemoteDataSource
import br.com.pedro.testepremiersoft.utils.performGetOperation
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val remoteDataSource: ArticleRemoteDataSource,
    private val localDataSource: ArticleDao
) {
    fun getArticles() = performGetOperation(
        {localDataSource.getAllArticles()},
        {remoteDataSource.getArticles()},
        {localDataSource.insertAll(it)}
    )
}