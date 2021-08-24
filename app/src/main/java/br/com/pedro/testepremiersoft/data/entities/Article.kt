package br.com.pedro.testepremiersoft.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "article")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName("author") val author : String,
    @SerializedName("title") val title : String,
    @SerializedName("description") val description : String,
    @SerializedName("url") val url : String,
    @SerializedName("urlToImage") val urlToImage : String,
    @SerializedName("publishedAt") val publishedAt : String,
    @SerializedName("content") val content : String

)
