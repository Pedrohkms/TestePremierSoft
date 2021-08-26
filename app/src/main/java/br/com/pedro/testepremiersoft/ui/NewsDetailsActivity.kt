package br.com.pedro.testepremiersoft.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import br.com.pedro.testepremiersoft.data.model.NewsDetails
import br.com.pedro.testepremiersoft.databinding.NewsDetailsBinding
import br.com.pedro.testepremiersoft.utils.dateFormat
import kotlinx.android.synthetic.main.item_recycler.*
import java.io.ByteArrayOutputStream

class NewsDetailsActivity : AppCompatActivity() {
    private lateinit var binding: NewsDetailsBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NewsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonShare = binding.share

        val news: NewsDetails? = intent.extras?.getParcelable("news")
        binding.title.text = news?.title
        Glide.with(binding.root).load(news?.urlToImage).into(binding.imageArticle)
        binding.author.text = news?.author ?: "Autor não Informado"
        binding.description.text = news?.description
        binding.content.text = news?.content
        binding.publishDate.text = dateFormat(news?.publishedAt)
        binding.source.text = "Fonte: ${news?.url}"

        buttonShare.setOnClickListener {
            val img: Bitmap? = getBitMapFromView(binding.imageArticle)

            val share = Intent(Intent.ACTION_SEND)
            share.type = "image/*"
            share.putExtra(Intent.EXTRA_STREAM, getImageUri(this, img!!, news?.title))
            startActivity(Intent.createChooser(share, "share via"))

        }
    }

    private fun getBitMapFromView(view: ImageView): Bitmap? {
        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.draw(canvas)
        return bitmap
    }

    private fun getImageUri(inContext: Context, inImage: Bitmap, title: String?): Uri? {
        val bytes = ByteArrayOutputStream()
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path =
            MediaStore.Images.Media.insertImage(inContext.contentResolver, inImage, title, null)
        return Uri.parse(path)
    }
}