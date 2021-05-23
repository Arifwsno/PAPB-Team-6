package com.example.projectfoodpedia.di

import androidx.room.Room
import com.example.projectfoodpedia.database.FavouritesDatabase
import com.example.projectfoodpedia.database.LocalDataSource
import com.example.projectfoodpedia.repository.IMealsRepository
import com.example.projectfoodpedia.repository.MealsRepository
import com.example.projectfoodpedia.service.MealsApi
import com.example.projectfoodpedia.source.RemoteDataSource
import com.example.projectfoodpedia.usecase.IMealUseCase
import com.example.projectfoodpedia.usecase.MealUseCase
import com.example.projectfoodpedia.utils.AppExecutors
import com.example.projectfoodpedia.utils.Constant.BASE_URL
import com.example.projectfoodpedia.viewmodel.DetailViewModel
import com.example.projectfoodpedia.viewmodel.FavouritesViewModel
import com.example.projectfoodpedia.viewmodel.HomeViewModel
import com.example.projectfoodpedia.viewmodel.MenuViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//dependencies injection
val repositoryModule = module {
    single { RemoteDataSource(get()) }
    single { LocalDataSource(get()) }
    factory { AppExecutors() }
    single<IMealsRepository> { MealsRepository(get(), get(), get()) }
}

val viewModel = module {
    viewModel { HomeViewModel(get()) }
    viewModel { (category: String) -> MenuViewModel(get(), category) }
    viewModel { FavouritesViewModel(get()) }
    viewModel { (meal: String) -> DetailViewModel(get(), meal) }
}

//Room Database Injection
val databaseModule = module {
    factory { get<FavouritesDatabase>().favouriteDao() }
    single {
        Room.databaseBuilder(
                androidContext(),
                FavouritesDatabase::class.java, "favourite_table.db"
        ).build()
    }
}

//Inisialisasi Retrofit menggunakan Injection
val networkModule = module {
    single {

        OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
    }
    single {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(get())
                .build()
        retrofit.create(MealsApi::class.java)
    }
}

val useCaseModule = module {
    factory <IMealUseCase>{ MealUseCase(get()) }
}