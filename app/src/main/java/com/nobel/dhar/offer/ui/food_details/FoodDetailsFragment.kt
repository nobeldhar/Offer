package com.nobel.dhar.offer.ui.food_details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.nobel.dhar.offer.R
import com.nobel.dhar.offer.databinding.FoodDetailsFragmentBinding
import com.nobel.dhar.offer.ui.home.FoodListViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FoodDetailsFragment : DaggerFragment() {

    companion object {
        fun newInstance() = FoodDetailsFragment()
    }

    private val TAG: String? = FoodDetailsFragment::class.simpleName
    val args: FoodDetailsFragmentArgs by navArgs()
    private lateinit var binding: FoodDetailsFragmentBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<FoodDetailsViewModel> { viewModelFactory }
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FoodDetailsFragmentBinding>(inflater,R.layout.food_details_fragment, container,false)

        navController = NavHostFragment.findNavController(this)
        binding.collapsingToolbarLayout.setupWithNavController(binding.toolbar, navController)
        NavigationUI.setupWithNavController(binding.collapsingToolbarLayout, binding.toolbar, navController)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getFoodById(args.FoodId).observe(viewLifecycleOwner, Observer {

            if (it.items.isNullOrEmpty()) {
                Log.d(TAG, "onActivityCreated: items null")
            } else {
                Log.d(TAG, "onActivityCreated: "+it.items[0].item_title)
                binding.model = it
            }

        })

        // TODO: Use the ViewModel
    }

}