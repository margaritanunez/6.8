package com.example.a68.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RazaPerrosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRaza(razaPerrosEntity: RazaPerrosEntity)

    @Query("select * from tabla_raza_perros order by raza asc")
    fun getRazas(): LiveData<List<RazaPerrosEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetallePerro(razaDetalleEntity: RazaDetalleEntity)

    @Query("select * from tabla_detalle_razas where razaDetalle like :id")
    fun getRazaDetalle(id: String): LiveData<List<RazaDetalleEntity>>
}