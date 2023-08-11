package com.example.a68.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.a68.data.local.RazaDetalleEntity
import com.example.a68.data.local.RazaPerrosDao
import com.example.a68.data.local.RazaPerrosEntity
import com.example.a68.data.remote.RazaPerrosApi

class Repository (private val razaPerrosApi: RazaPerrosApi, private val razaPerrosDao: RazaPerrosDao){

    fun getRazaEntity(): LiveData<List<RazaPerrosEntity>>  = razaPerrosDao.getRazas()
    fun getDetalleEntity(id: String): LiveData<List<RazaDetalleEntity>> =razaPerrosDao.getRazaDetalle(id)

    suspend fun getRazas(){
        val response = razaPerrosApi.getData()
        if (response.isSuccessful) {
            val message = response.body()!!.message
            val keys= message.keys
            keys.forEach{raza->
                val razaPerrosEntity= raza.toRazaEntity()
                razaPerrosDao.insertRaza(razaPerrosEntity)

            }
        } else
            Log.e("repositorio", response.errorBody().toString())
    }

    suspend fun getDetallePerro(id:String){
        val response = razaPerrosApi.getDetallePerro(id)
        if (response.isSuccessful) {
            response.body()!!.message.forEach{url->
                val razaDetalleEntity = url.toEntity(id)
                razaPerrosDao.insertDetallePerro(razaDetalleEntity)
            }

        }else
            Log.e("repositorio", response.errorBody().toString())
    }

}