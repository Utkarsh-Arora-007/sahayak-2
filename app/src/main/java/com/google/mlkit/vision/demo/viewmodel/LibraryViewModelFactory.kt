package com.google.mlkit.vision.demo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.mlkit.vision.demo.network.MainRepository

class LibraryViewModelFactory (private val repository: MainRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LibraryViewModel(repository) as T

    }

}