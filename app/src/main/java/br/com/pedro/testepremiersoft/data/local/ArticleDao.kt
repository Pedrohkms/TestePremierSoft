package br.com.pedro.testepremiersoft.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.pedro.testepremiersoft.data.entities.Article

@Dao
interface ArticleDao {
    @Query("SELECT * FROM article")
    fun getAllArticles(): LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(articles: List<Article>)
}