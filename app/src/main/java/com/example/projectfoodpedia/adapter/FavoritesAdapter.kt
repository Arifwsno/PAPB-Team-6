package com.example.projectfoodpedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.projectfoodpedia.FavouritesFragmentDirections
import com.example.projectfoodpedia.R
import com.example.projectfoodpedia.databinding.FavoritesItemBinding
import com.example.projectfoodpedia.datamakanan.model.MealDetailsModel
import com.example.projectfoodpedia.utils.CustomOnClick

class FavoritesAdapter: RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>(), CustomOnClick {

    private var listFavorites = ArrayList<MealDetailsModel>()

    fun setData(newList: List<MealDetailsModel>?){
        if (newList == null) return
        listFavorites.clear()
        listFavorites.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoritesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<FavoritesItemBinding>(inflater, R.layout.favorites_item, parent, false)
        return FavoritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.view.favorite = listFavorites[position]
        holder.view.listener = this
    }

    override fun getItemCount(): Int = listFavorites.size

    override fun onClicked(view: View) {
        for (favourites in listFavorites){
            if (view.tag == favourites.name){
                val action = FavouritesFragmentDirections.actionFavouriteToFavouritesDetails(favourites)
                Navigation.findNavController(view).navigate(action)
            }
        }
    }

    class FavoritesViewHolder(var view: FavoritesItemBinding): RecyclerView.ViewHolder(view.root) {

    }
}