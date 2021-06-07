package com.example.projectfoodpedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.projectfoodpedia.databinding.FragmentFoodDetailsBinding
import com.example.projectfoodpedia.databinding.FragmentWelcomePageBinding
import com.example.projectfoodpedia.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_welcome_page.*

class WelcomePage : Fragment() {
    private lateinit var dataBinding: FragmentWelcomePageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome_page, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_loginWelcomepage.setOnClickListener{
            val action=WelcomePageDirections.actionWelcomePageToLogin()
            Navigation.findNavController(view).navigate(action)
        }

        btn_signupWelcomepage.setOnClickListener {
            val action = WelcomePageDirections.actionWelcomePageToSignup()
            Navigation.findNavController(view).navigate(action)
        }
    }
}