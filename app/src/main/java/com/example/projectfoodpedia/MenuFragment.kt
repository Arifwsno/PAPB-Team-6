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
import com.example.projectfoodpedia.adapter.HomeAdapter
import com.example.projectfoodpedia.adapter.MenuAdapter
import com.example.projectfoodpedia.databinding.FragmentHomeBinding
import com.example.projectfoodpedia.databinding.FragmentMenuBinding
import com.example.projectfoodpedia.viewmodel.HomeViewModel
import com.example.projectfoodpedia.viewmodel.MenuViewModel
import kotlinx.android.synthetic.main.fragment_menu.*
import org.koin.android.viewmodel.ext.android.getViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MenuFragment : Fragment() {
//    companion object {
//        var categoryMeal = ""
//    }

    private val args: MenuFragmentArgs by navArgs()
    private lateinit var viewModel: MenuViewModel
    private var menuAdapter = MenuAdapter()
    private lateinit var dataBinding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false)
        var categoryMeal = args.category.category
        Log.i("args",categoryMeal)
        viewModel = getViewModel { parametersOf(categoryMeal) }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_FoodCard.apply {
            adapter = menuAdapter
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.getListMeal().observe(viewLifecycleOwner, Observer { category ->
            category?.let {
                menuAdapter.setData(it.meals)
            }
        })
    }
}