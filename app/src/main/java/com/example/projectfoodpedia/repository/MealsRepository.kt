package com.example.projectfoodpedia.repository

import android.util.Log
import com.example.projectfoodpedia.database.LocalDataSource
import com.example.projectfoodpedia.datamakanan.*
import com.example.projectfoodpedia.datamakanan.model.CategoryModel
import com.example.projectfoodpedia.datamakanan.model.MealDetailsModel
import com.example.projectfoodpedia.datamakanan.model.MealModel
import com.example.projectfoodpedia.networkresource.NetworkBoundResource
import com.example.projectfoodpedia.networkresource.Resource
import com.example.projectfoodpedia.service.ApiResponse
import com.example.projectfoodpedia.source.RemoteDataSource
import com.example.projectfoodpedia.utils.AppExecutors
import com.example.projectfoodpedia.utils.DataMapper
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MealsRepository(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource,
        private val appExecutors: AppExecutors) : IMealsRepository {
    override fun getCategory(): Single<List<CategoryModel>> {
        return remoteDataSource.getCategory().map {
            DataMapper.mapCategoryResponsesToDomain(it.categories)
        }
    }

    override fun getListMeal(category: String): Single<List<MealModel>> {
        return remoteDataSource.getListMeal(category).map {
            DataMapper.mapMealResponseToDomain(it.meals)
        }
    }

    override fun getDetail(id: String): Flow<Resource<MealDetailsModel>> {
        return object : NetworkBoundResource<MealDetailsModel, List<MealDetailsResponse>>() {
            override fun loadFromDB(): Flow<MealDetailsModel> {
                return localDataSource.getDetailMeal(id).map {
                    DataMapper.mapMealDetailEntityToDomain(it)
                }
            }

            override fun shouldFetch(data: MealDetailsModel?): Boolean = // ini return langsung
                    data == null || data.name.isNullOrEmpty()// ini sama aja --> return data == null

            override suspend fun createCall(): Flow<ApiResponse<List<MealDetailsResponse>>> {
                return remoteDataSource.getDetails(id)
            }


            override suspend fun saveCallResult(data: List<MealDetailsResponse>) {
                val mealEntity = DataMapper.mapMealDetailsResponseToEntity(data)
                localDataSource.addFavourites(mealEntity)
            }
        }.asFlow()
    }

    override fun getFavouriteMeal(): Flow<List<MealDetailsModel>> {
        return localDataSource.getAllFavouriteMeal().map {
            DataMapper.mapMealDetailEntitiesToDomains(it)
        }
    }

    override fun setFavouriteMeal(mealDetailsModel: MealDetailsModel, state: Boolean) {
        val mealEntity = DataMapper.mapMealDetailDomainToEntity(mealDetailsModel)
        appExecutors.diskIO().execute {
            localDataSource.updateFavouriteMeal(mealEntity, state)
        }
    }

}