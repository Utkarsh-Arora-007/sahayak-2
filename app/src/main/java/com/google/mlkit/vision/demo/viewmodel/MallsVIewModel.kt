package com.google.mlkit.vision.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.mlkit.vision.demo.dataclass.Malls
import com.google.mlkit.vision.demo.network.MainRepository
import kotlinx.coroutines.launch

class MallsVIewModel (private val repository: MainRepository): ViewModel() {

    val myResponse: MutableLiveData<Malls> = MutableLiveData()
    fun getMalls(){
        viewModelScope.launch {
            val response: Malls = repository.getMalls()
            myResponse.value = response
        }
    }

}