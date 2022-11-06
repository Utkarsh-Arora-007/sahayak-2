package com.google.mlkit.vision.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.mlkit.vision.demo.dataclass.Toilets
import com.google.mlkit.vision.demo.network.MainRepository
import kotlinx.coroutines.launch

class ToiletsViewModel (private val repository: MainRepository): ViewModel() {

    val myResponse: MutableLiveData<Toilets> = MutableLiveData()
    fun getToilets(){
        viewModelScope.launch {
            val response: Toilets = repository.getToilets()
            myResponse.value = response
        }
    }

}