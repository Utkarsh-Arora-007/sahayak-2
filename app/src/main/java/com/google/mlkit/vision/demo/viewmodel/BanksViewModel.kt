package com.google.mlkit.vision.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.mlkit.vision.demo.dataclass.Banks
import com.google.mlkit.vision.demo.network.MainRepository
import kotlinx.coroutines.launch

class BanksViewModel(private val repository: MainRepository): ViewModel() {

    val myResponse: MutableLiveData<Banks> = MutableLiveData()
    fun getBank(){
        viewModelScope.launch {
            val response: Banks = repository.getBanks()
            myResponse.value = response
        }
    }

}