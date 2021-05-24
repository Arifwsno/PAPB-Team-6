package com.example.projectfoodpedia

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.drawable.DrawableCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.projectfoodpedia.databinding.FragmentFoodDetailsBinding
import com.example.projectfoodpedia.networkresource.Resource
import com.example.projectfoodpedia.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_food_details.*
import org.koin.android.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf


class FoodDetailsFragment : Fragment() {

    private val args: FoodDetailsFragmentArgs by navArgs()
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentFoodDetailsBinding

    // Notification Properties
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelID = "com.example.projectfoodpedia"
    private val description = "Food Notification"

    var status = false

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_food_details, container, false)

        // Notification Setup
        notificationManager =
                activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notificationIntent = Intent(activity, LauncherActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
                activity,
                0,
                notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        )

        // Notification action
        dataBinding.btnNotification.setOnClickListener {
            notificationChannel = NotificationChannel(
                    channelID,
                    description,
                    NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.BLUE
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(activity, channelID)
                    .setContentTitle(tv_foodDetailsTitle.text.toString())
                    .setContentText("Your food is ready!")
                    .setSmallIcon(R.drawable.ic_launcher_round)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher))
                    .setContentIntent(pendingIntent)

            notificationManager.notify(1234, builder.build())
        }

        var categoryMeal = args.meal.id
        viewModel = getViewModel { parametersOf(categoryMeal) }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()

        fab_favourites.setOnClickListener {
            status = !status!!
            dataBinding.detail?.let {
                viewModel.setFavouriteMeals(it, status)
            }
            setFavouriteStatus(status)
        }
    }

    private fun setFavouriteStatus(status: Boolean) {
        var buttonDrawable: Drawable? = fab_favourites.getBackground()
        buttonDrawable = DrawableCompat.wrap(buttonDrawable!!)
        if (status){
            Toast.makeText(requireContext(), "Succesfully Added!", Toast.LENGTH_LONG).show()
            DrawableCompat.setTint(buttonDrawable, Color.RED)
            fab_favourites.setBackground(buttonDrawable)
        }
        else{
            Toast.makeText(requireContext(), "Succesfully Removed!", Toast.LENGTH_LONG).show()
            DrawableCompat.setTint(buttonDrawable, Color.CYAN)
            fab_favourites.setBackground(buttonDrawable)
        }
    }

    private fun observeViewModel() {
        viewModel.dataDetail.observe(viewLifecycleOwner, Observer { detail ->
            if (detail != null) {
                when (detail) {
                    is Resource.Loading -> null
                    is Resource.Error -> Log.e("error", detail.message.toString())
                    is Resource.Success -> {
                        dataBinding.detail = detail.data
                        status = detail.data?.isFavourite ?: false
                    }
                }
            }
        })
    }
}