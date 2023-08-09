package com.example.a68.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.a68.data.local.RazaPerrosDao
import com.example.a68.data.local.RazaPerrosEntity
import com.example.a68.data.remote.RazaPerrosApi

class Repository (private val razaPerrosApi: RazaPerrosApi, private val razaPerrosDao: RazaPerrosDao){

    fun getRazaEntity(): LiveData<List<RazaPerrosEntity>>  = razaPerrosDao.getRazas()

    suspend fun getRazas(){
        val response = razaPerrosApi.getData()
        if (response.isSuccessful) {
            val message = response.body()!!.message
            val keys= message.keys
            keys.forEach{
                val razaPerrosEntity= RazaPerrosEntity(it)
                razaPerrosDao.insertRaza(razaPerrosEntity)

            }
        } else
            Log.e("repositorio", response.errorBody().toString())
    }

}