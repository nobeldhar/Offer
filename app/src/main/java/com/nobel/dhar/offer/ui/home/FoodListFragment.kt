package com.nobel.dhar.offer.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.nobel.dhar.offer.R
import com.nobel.dhar.offer.databinding.FragmentFoodListBinding
import com.nobel.dhar.offer.factory.AppViewModelFactory
import com.nobel.dhar.offer.utils.Resource
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FoodListFragment : DaggerFragment() {

    private val TAG = "FoodListFragment"

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val foodListViewModel by viewModels<FoodListViewModel> { viewModelFactory }
    private lateinit var binding: FragmentFoodListBinding
    private lateinit var listener: CustomClickListener
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_food_list, container, false)
        navController = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        foodListViewModel.allFoods.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    //binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) binding.adapter = FoodAdapter(it.data, listener)
                }
                Resource.Status.ERROR -> {
                    Log.d(TAG, "onActivityCreated: " + it.message)
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }

                Resource.Status.LOADING ->
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications
            )
        )
        NavigationUI.setupWithNavController(binding.toolbarHome, navController, appBarConfiguration)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CustomClickListener) {
            listener = context
        } else {
            throw ClassCastException(
                context.toString() + " must implement CustomClickListener."
            )
        }
    }


}
