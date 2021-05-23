package com.example.projectfoodpedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projectfoodpedia.adapter.FavoritesAdapter
import com.example.projectfoodpedia.adapter.MenuAdapter
import com.example.projectfoodpedia.databinding.FragmentFavouritesBinding
import com.example.projectfoodpedia.viewmodel.FavouritesViewModel
import kotlinx.android.synthetic.main.fragment_favourites.*
import org.koin.android.viewmodel.ext.android.viewModel

class FavouritesFragment : Fragment() {

    private val viewModel: FavouritesViewModel by viewModel()
    private val favouriteAdapter = FavoritesAdapter()
    private lateinit var dataBinding: FragmentFavouritesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_favourites, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_favourites.apply {
            adapter = favouriteAdapter
            layoutManager = GridLayoutManager(context,2)
        }

        observeFavoriteList()

    }

    private fun observeFavoriteList() {
        viewModel.dataFavourite.observe(viewLifecycleOwner, Observer { favorite ->
            favouriteAdapter.setData(favorite)
        })
    }
}