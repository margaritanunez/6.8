package com.example.a68.data.local

import androidx.room.Entity

@Entity(tableName = "tabla_detalle_razas", primaryKeys = ["razaDetalle", "url"])
data class RazaDetalleEntity(val razaDetalle: String, val url : String)
