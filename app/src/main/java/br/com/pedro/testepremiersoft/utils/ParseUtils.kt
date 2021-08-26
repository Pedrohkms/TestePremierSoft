package br.com.pedro.testepremiersoft.utils

import java.text.SimpleDateFormat
import java.util.*


fun dateFormat(stringDate: String?): String? {
    val dateFormat = SimpleDateFormat("d/MM/yyyy")
    val date: Date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(stringDate)
    return dateFormat.format(date)
}
