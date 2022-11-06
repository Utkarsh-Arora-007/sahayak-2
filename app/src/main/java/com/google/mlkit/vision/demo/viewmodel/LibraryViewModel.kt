package com.google.mlkit.vision.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.mlkit.vision.demo.dataclass.Libraries
import com.google.mlkit.vision.demo.network.MainRepository
import kotlinx.coroutines.launch

class LibraryViewModel (private val repository: MainRepository): ViewModel() {

    val myResponse: MutableLiveData<Libraries> = MutableLiveData()
    fun getLibrary(){
        viewModelScope.launch {
            val response: Libraries = repository.getLibraries()
            myResponse.value = response
        }
    }

}