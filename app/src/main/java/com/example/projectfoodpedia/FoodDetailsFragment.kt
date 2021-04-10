package com.example.projectfoodpedia

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.projectfoodpedia.adapter.MenuAdapter
import com.example.projectfoodpedia.databinding.FragmentFoodDetailsBinding
import com.example.projectfoodpedia.databinding.FragmentMenuBinding
import com.example.projectfoodpedia.viewmodel.DetailViewModel
import com.example.projectfoodpedia.viewmodel.MenuViewModel
import kotlinx.android.synthetic.main.fragment_food_details.*
import kotlinx.android.synthetic.main.fragment_menu.*
import org.koin.android.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf

class FoodDetailsFragment : Fragment() {

    private val args: FoodDetailsFragmentArgs by navArgs()
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentFoodDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_food_details, container, false)
        var categoryMeal = args.meal.id.toString()
        Log.i("args", categoryMeal)
        viewModel = getViewModel { parametersOf(categoryMeal) }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.getDetail().observe(viewLifecycleOwner, Observer { detail ->
            detail?.let {
                dataBinding.detail = it
//                tv_foodDetailsTitle.text = it.name
//                tv_foodDetailsCategory.text = it.category
//                tv_instruction.text = it.instruction
//                Log.i("args", it.name.toString())
//                Log.i("args", it.category.toString())
//                Log.i("args", it.instruction.toString())
//                Log.i("args", dataBinding.detail.toString())
            }
        })
    }
}