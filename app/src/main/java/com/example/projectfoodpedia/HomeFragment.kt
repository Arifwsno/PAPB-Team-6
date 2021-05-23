package com.example.projectfoodpedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projectfoodpedia.adapter.HomeAdapter
import com.example.projectfoodpedia.databinding.FragmentHomeBinding
import com.example.projectfoodpedia.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()
    private var homeAdapter = HomeAdapter()
    private lateinit var dataBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_PlaceCard.apply {
            adapter = homeAdapter
        }
        viewModel.getCategory()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.dataCategory.observe(viewLifecycleOwner, Observer {
            homeAdapter.setData(it)
        })
    }
}