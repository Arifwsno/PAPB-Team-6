package com.example.projectfoodpedia.di

import com.example.projectfoodpedia.repository.IMealsRepository
import com.example.projectfoodpedia.repository.MealsRepository
import com.example.projectfoodpedia.source.RemoteDataSource
import com.example.projectfoodpedia.viewmodel.DetailViewModel
import com.example.projectfoodpedia.viewmodel.HomeViewModel
import com.example.projectfoodpedia.viewmodel.MenuViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single { RemoteDataSource() }
    single<IMealsRepository> { MealsRepository(get()) }
}

val viewModel = module {
    viewModel { HomeViewModel(get()) }
    viewModel { (category: String) -> MenuViewModel(get(), category) }
    viewModel { (meal: String) -> DetailViewModel(get(), meal) }
}