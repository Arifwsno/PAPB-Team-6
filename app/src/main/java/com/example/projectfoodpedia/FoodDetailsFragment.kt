package com.example.projectfoodpedia

import android.graphics.Color
import android.graphics.Color.red
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.projectfoodpedia.databinding.FragmentFoodDetailsBinding
import com.example.projectfoodpedia.networkresource.Resource
import com.example.projectfoodpedia.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_food_details.*
import org.koin.android.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf

class FoodDetailsFragment : Fragment() {

    private val args: FoodDetailsFragmentArgs by navArgs()
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentFoodDetailsBinding

    var status = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_food_details, container, false)

        var categoryMeal = args.meal.id
        viewModel = getViewModel { parametersOf(categoryMeal) }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()

        fab_favourites.setOnClickListener {
            status = !status!!
            dataBinding.detail?.let {
                viewModel.setFavouriteMeals(it, status)
            }
            setFavouriteStatus(status)
        }
    }

    private fun setFavouriteStatus(status: Boolean) {
        if (status){
            fab_favourites.(context?.let {
                ContextCompat.getColor(
                        it,
                        R.color.design_default_color_error
                )
            })
        }
        else{
            fab_favourites.setBackgroundColor(Color.CYAN)
        }

//        fab_tv_show.setImageDrawable(context?.let {
//            ContextCompat.getDrawable(
//                it,
//                R.drawable.ic_favorite
//            )
//        })
    }

    private fun observeViewModel() {
        viewModel.dataDetail.observe(viewLifecycleOwner, Observer { detail ->
            if (detail != null) {
                when (detail) {
                    is Resource.Loading -> null
                    is Resource.Error -> Log.e("error", detail.message.toString())
                    is Resource.Success -> {
                        dataBinding.detail = detail.data
                        status = detail.data?.isFavourite ?: false
                    }
                }
            }
        })
    }
}