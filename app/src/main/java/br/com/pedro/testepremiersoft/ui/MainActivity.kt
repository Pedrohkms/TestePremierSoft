package br.com.pedro.testepremiersoft.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import br.com.pedro.testepremiersoft.databinding.ActivityMainBinding
import br.com.pedro.testepremiersoft.ui.Adapter.RecyclerViewAdapter
import br.com.pedro.testepremiersoft.viewModel.ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: ViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        binding.refreshList.setOnRefreshListener {
            setupView()
        }

    }

    private fun setupView() {
        viewModel.getNews()

        viewModel.errorMessage().observe(this, { error ->
            binding.textView.text = "Error : $error "
        })
        viewModel.newsList().observe(this, { newsList ->
            binding.textView.visibility = View.GONE
            binding.recyclerView.layoutManager = GridLayoutManager(this, 1);
            binding.recyclerView.adapter = RecyclerViewAdapter(newsList)
        })
        onItemsLoadComplete()
    }

    private fun onItemsLoadComplete() {
        binding.refreshList.isRefreshing = false
    }
}