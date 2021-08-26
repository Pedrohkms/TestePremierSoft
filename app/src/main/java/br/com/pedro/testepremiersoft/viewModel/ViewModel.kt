package br.com.pedro.testepremiersoft.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.pedro.testepremiersoft.data.model.NewsDetails
import br.com.pedro.testepremiersoft.utils.NewsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class ViewModel(private val useCase: NewsUseCase) : ViewModel() {


    private var newsList = MutableLiveData<List<NewsDetails>>()
    private var errorMessage = MutableLiveData<String>()
    private val compositeDisposable = CompositeDisposable()


    fun newsList(): LiveData<List<NewsDetails>> = newsList
    fun errorMessage(): LiveData<String> = errorMessage


    fun getNews() {
        useCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ articles ->
                newsList.value = articles
            }, { error ->
                errorMessage.value = error.message
            })
            .addTo(compositeDisposable)
    }
}