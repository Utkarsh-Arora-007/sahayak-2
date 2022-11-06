package com.google.mlkit.vision.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.mlkit.vision.demo.dataclass.Hospitals
import com.google.mlkit.vision.demo.network.MainRepository
import kotlinx.coroutines.launch

class HospitalViewModel (private val repository: MainRepository): ViewModel() {

    val myResponse: MutableLiveData<Hospitals> = MutableLiveData()
    fun getHospital(){
        viewModelScope.launch {
            val response: Hospitals = repository.getHospitals()
            myResponse.value = response
        }
    }

}