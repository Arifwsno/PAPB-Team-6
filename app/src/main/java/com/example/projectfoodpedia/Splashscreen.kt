package com.example.projectfoodpedia

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class Splashscreen : Fragment() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_splashscreen)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
//        Handler().postDelayed({
//            val mIntent = Intent(this@Splashscreen, MainActivity::class.java)
//            startActivity(mIntent)
//            finish()
//        }, 2000L)
        return inflater.inflate(R.layout.fragment_splashscreen, container, false)
    }

}