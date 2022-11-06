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
import com.google.mlkit.vision.demo.adapter.RestroAdapter
import com.google.mlkit.vision.demo.databinding.FragmentRestroBinding
import com.google.mlkit.vision.demo.network.MainRepository
import com.google.mlkit.vision.demo.viewmodel.RestrauntsViewModel
import com.google.mlkit.vision.demo.viewmodel.RestrauntsViewModelFactory

// TODO: Rename parameter arguments, choose names that match
class RestroFragment : Fragment() {

    lateinit var binding:FragmentRestroBinding
    lateinit var viewModel: RestrauntsViewModel
    private val restroAdapter:RestroAdapter by lazy{ RestroAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentRestroBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = MainRepository()
        val viewModelFactory = RestrauntsViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(RestrauntsViewModel::class.java)
        viewModel.getRestraunts()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer {
            restroAdapter.setRestro(it)
//            binding.progressBar.visibility = View.GONE
        })
        binding.restroRecyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.restroRecyclerView.adapter = restroAdapter


    }

}