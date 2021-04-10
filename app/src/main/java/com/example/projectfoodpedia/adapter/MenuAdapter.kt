package com.example.projectfoodpedia.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.projectfoodpedia.HomeFragmentDirections
import com.example.projectfoodpedia.MenuFragmentDirections
import com.example.projectfoodpedia.R
import com.example.projectfoodpedia.databinding.FoodCardBinding
import com.example.projectfoodpedia.datamakanan.MealResponse
import com.example.projectfoodpedia.utils.CustomOnClick
import kotlinx.android.synthetic.main.food_card.view.*

class MenuAdapter : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(), CustomOnClick {

    private var listData = ArrayList<MealResponse>()

    fun setData(newList: ArrayList<MealResponse>?) {
        if (newList==null)return
        listData.clear()
        listData.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =
            DataBindingUtil.inflate<FoodCardBinding>(inflater, R.layout.food_card, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.view.meal = listData[position]
        holder.view.listener = this
    }

    override fun getItemCount(): Int = listData.size

    class MenuViewHolder(var view: FoodCardBinding) : RecyclerView.ViewHolder(view.root)

    override fun onClicked(view: View) {
//        val mealName = view.tv_foodTitle.toString()
//        val action = MenuFragmentDirections.actionMenuToDetail(mealName)
//        Navigation.findNavController(view).navigate(action)
        for (meal in listData){
            if (view.tag==meal.name){
                val action= MenuFragmentDirections.actionMenuToDetail(meal)
                Navigation.findNavController(view).navigate(action)
            }
        }
    }
}