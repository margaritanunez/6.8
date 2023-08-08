package com.example.a68.data

import com.example.a68.data.local.RazaPerrosDao
import com.example.a68.data.local.RazaPerrosEntity
import com.example.a68.data.remote.RazaPerrosApi

class Repository (private val razaPerrosApi: RazaPerrosApi, private val razaPerrosDao: RazaPerrosDao){

    suspend fun getRazas(){
        val response = razaPerrosApi.getData()
        if (response.isSuccessful) {
            val message = response.body()!!.message
            val keys= message.keys
            keys.forEach{
                val razaPerrosEntity= RazaPerrosEntity(it)
                razaPerrosDao.insertRaza(razaPerrosEntity)

            }
        }
    }

}