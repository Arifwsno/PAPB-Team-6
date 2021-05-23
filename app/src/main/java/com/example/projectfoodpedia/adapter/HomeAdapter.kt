package com.example.projectfoodpedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.projectfoodpedia.HomeFragmentDirections
import com.example.projectfoodpedia.R
import com.example.projectfoodpedia.databinding.CategoryItemBinding
import com.example.projectfoodpedia.datamakanan.CategoryResponse
import com.example.projectfoodpedia.datamakanan.model.CategoryModel
import com.example.projectfoodpedia.utils.CustomOnClick
import kotlinx.android.synthetic.main.category_item.view.*

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(), CustomOnClick {

    private var listData = ArrayList<CategoryModel>()

    fun setData(newList: List<CategoryModel>) {
        listData.clear()
        listData.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<CategoryItemBinding>(
            inflater,
            R.layout.category_item,
            parent,
            false
        )
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.view.category = listData[position]
        holder.view.listener = this
    }

    override fun getItemCount(): Int = listData.size

    class HomeViewHolder(var view: CategoryItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onClicked(view: View) {
        for (category in listData){
            if (view.tag==category.category){
                val action=HomeFragmentDirections.actionHomeToMenu(category)
                Navigation.findNavController(view).navigate(action)
            }
        }
    }
}