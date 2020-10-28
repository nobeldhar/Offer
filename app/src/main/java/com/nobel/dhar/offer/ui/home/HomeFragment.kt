package com.nobel.dhar.offer.ui.home

import android.content.Context
import android.os.Bundle
import android.telecom.Connection
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.nobel.dhar.offer.R
import com.nobel.dhar.offer.databinding.FragmentHomeBinding
import com.nobel.dhar.offer.persistence.Food
import com.nobel.dhar.offer.persistence.FoodWithItems

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    private lateinit var listener: CustomClickListener
    private lateinit var navController: NavController

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        navController = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.allFoods.observe(viewLifecycleOwner, Observer {
            if (it.isNullOrEmpty()){
                Toast.makeText(context, "Null", Toast.LENGTH_SHORT).show()
            }else {
                binding.adapter = FoodAdapter(it, listener)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        NavigationUI.setupWithNavController(binding.toolbarHome, navController, appBarConfiguration)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CustomClickListener) {
            listener = context
        } else {
            throw ClassCastException(
                context.toString() + " must implement CustomClickListener.")
        }
    }


}
