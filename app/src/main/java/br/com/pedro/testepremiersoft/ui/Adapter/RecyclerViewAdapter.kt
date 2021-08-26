package br.com.pedro.testepremiersoft.ui.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.pedro.testepremiersoft.data.model.NewsDetails
import br.com.pedro.testepremiersoft.databinding.ItemRecyclerBinding
import br.com.pedro.testepremiersoft.ui.NewsDetailsActivity
import br.com.pedro.testepremiersoft.utils.dateFormat
import com.bumptech.glide.Glide


class RecyclerViewAdapter(private val newsArrayList: List<NewsDetails>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {


    inner class MyViewHolder(private val binding: ItemRecyclerBinding) : ViewHolder(binding.root){
        fun bind(item: NewsDetails) {
            binding.newsDetail = item
            Glide.with(binding.root).load(item.urlToImage).into(binding.image)
            binding.titleNews.text = item.title
            binding.author.text = item.author ?: "Autor não Identificado"
            binding.date.text = dateFormat(item.publishedAt)
        }
        init {
            binding.root.setOnClickListener {
                val intent = Intent(it.context, NewsDetailsActivity::class.java)
                    .putExtra("news",binding.newsDetail)
                ContextCompat.startActivity(it.context, intent, null)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: ItemRecyclerBinding = ItemRecyclerBinding.inflate(
            layoutInflater,
            parent,
            false
        )
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = newsArrayList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }
}
