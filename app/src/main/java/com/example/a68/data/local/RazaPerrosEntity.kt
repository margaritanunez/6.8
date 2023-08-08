package com.example.a68.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_raza_perros")
data class RazaPerrosEntity(val raza:String)

{
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}
