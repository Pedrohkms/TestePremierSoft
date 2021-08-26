package br.com.pedro.testepremiersoft.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class NewsModel (
    var status: String? = null,
    var articles: List<NewsDetails>? = null
)

@Parcelize
data class NewsDetails (
    var author: String? = null,
    var title: String? = null,
    var description: String? = null,
    var url: String? = null,
    var urlToImage: String? = null,
    var publishedAt: String? = null,
    var content: String? = null
): Parcelable