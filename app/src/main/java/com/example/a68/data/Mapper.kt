package com.example.a68.data

import com.example.a68.data.local.RazaDetalleEntity
import com.example.a68.data.local.RazaPerrosEntity

fun String.toEntity(id: String): RazaDetalleEntity = RazaDetalleEntity(id, this)

fun String.toRazaEntity(): RazaPerrosEntity = RazaPerrosEntity(this)