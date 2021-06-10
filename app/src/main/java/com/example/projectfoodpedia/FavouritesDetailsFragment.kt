package com.example.projectfoodpedia

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.drawable.DrawableCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.projectfoodpedia.databinding.FragmentFavouritesDetailsBinding
import com.example.projectfoodpedia.networkresource.Resource
import com.example.projectfoodpedia.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_favourites_details.*
import org.koin.android.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf


class FavouritesDetailsFragment : Fragment() {
    private val args: FavouritesDetailsFragmentArgs by navArgs()
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentFavouritesDetailsBinding

    var status = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_favourites_details, container, false)

        var favouriteDetails = args.meal.id
        viewModel = getViewModel { parametersOf(favouriteDetails) }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()

        fab_favouritesFavourites.setOnClickListener {
            status = !status!!
            dataBinding.detail?.let {
                viewModel.setFavouriteMeals(it, status)
            }
            setFavouriteStatus(status)
        }
    }

    private fun setFavouriteStatus(status: Boolean) {
        var buttonDrawable: Drawable? = fab_favouritesFavourites.getBackground()
        buttonDrawable = DrawableCompat.wrap(buttonDrawable!!)
        if (status){
            Toast.makeText(requireContext(), "Succesfully Added!", Toast.LENGTH_LONG).show()
            DrawableCompat.setTint(buttonDrawable, Color.RED)
            fab_favouritesFavourites.setBackground(buttonDrawable)
        }
        else{
            Toast.makeText(requireContext(), "Succesfully Removed!", Toast.LENGTH_LONG).show()
            DrawableCompat.setTint(buttonDrawable, Color.GREEN)
            fab_favouritesFavourites.setBackground(buttonDrawable)
        }
    }

    private fun observeViewModel(){
        viewModel.dataDetail.observe(viewLifecycleOwner, Observer { detail ->
            if (detail != null){
                when(detail){
                    is Resource.Loading -> null
                    is Resource.Error -> Log.e("error", detail.message.toString())
                    is Resource.Success -> {
                        dataBinding.detail = detail.data
                    }
                }
            }
        })

    }

}