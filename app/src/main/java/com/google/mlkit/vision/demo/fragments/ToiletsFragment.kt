package com.google.mlkit.vision.demo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.mlkit.vision.demo.R
import com.google.mlkit.vision.demo.adapter.ToiletsAdapter
import com.google.mlkit.vision.demo.databinding.FragmentToiletsBinding
import com.google.mlkit.vision.demo.network.MainRepository
import com.google.mlkit.vision.demo.viewmodel.ToiletsViewModel
import com.google.mlkit.vision.demo.viewmodel.ToiletsViewModelFactory

class ToiletsFragment : Fragment() {

    lateinit var binding:FragmentToiletsBinding
    lateinit var viewModel: ToiletsViewModel
    private val restroAdapter: ToiletsAdapter by lazy{ ToiletsAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentToiletsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = MainRepository()
        val viewModelFactory = ToiletsViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(ToiletsViewModel::class.java)
        viewModel.getToilets()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer {
            restroAdapter.setRestro(it)
        })
        binding.toiletsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.toiletsRecyclerView.adapter = restroAdapter


    }
}