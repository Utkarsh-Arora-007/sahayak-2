package com.google.mlkit.vision.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.mlkit.vision.demo.dataclass.Restraunts
import com.google.mlkit.vision.demo.network.MainRepository
import kotlinx.coroutines.launch

class RestrauntsViewModel (private val repository: MainRepository): ViewModel() {

    val myResponse: MutableLiveData<Restraunts> = MutableLiveData()
    fun getRestraunts(){
        viewModelScope.launch {
            val response: Restraunts = repository.getRestraunts()
            myResponse.value = response
        }
    }

}