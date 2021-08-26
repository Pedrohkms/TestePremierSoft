package br.com.pedro.testepremiersoft.di

import br.com.pedro.testepremiersoft.data.api.OkHttpBuilder
import br.com.pedro.testepremiersoft.data.api.RetrofitBuilder
import br.com.pedro.testepremiersoft.data.repository.NewsRepository
import br.com.pedro.testepremiersoft.utils.NewsUseCase
import br.com.pedro.testepremiersoft.viewModel.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


@JvmField
val appModule = module {

    factory { NewsRepository(get()) }

    factory{ NewsUseCase(get()) }

    viewModel { ViewModel(get()) }

    single { OkHttpBuilder().build() }

    single { RetrofitBuilder(get()).build(get())}
}