package com.tuna.nothingapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tuna.nothingapp.R
import com.tuna.nothingapp.databinding.FragmentCityListBinding
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityListFragment : Fragment() {
    private lateinit var binding: FragmentCityListBinding
    private lateinit var viewModel: MainSharedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainSharedViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_city_list, container, false)
        return binding.root
    }
}