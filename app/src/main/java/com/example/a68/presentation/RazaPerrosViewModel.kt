package com.example.a68.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.a68.data.Repository
import com.example.a68.data.local.RazaPerrosDataBase
import com.example.a68.data.remote.RazaRetrofitClient
import kotlinx.coroutines.launch

class RazaPerrosViewModel (application: Application): AndroidViewModel(application) {

    private val repository: Repository

    init{
        val razaPerrosApi = RazaRetrofitClient.getRetrofitRaza()
        val razaPerrosDataBase = RazaPerrosDataBase.getDatabase(application).getRazaDao()
        repository = Repository(razaPerrosApi, razaPerrosDataBase)
    }

    fun getAllRazas()= viewModelScope.launch {
        repository.getRazas()
    }

    fun razaPerrosLiveData() = repository.getRazaEntity()

    fun getDetallePerroViewModel(id: String) = viewModelScope.launch{
        repository.getDetallePerro(id)
    }
}