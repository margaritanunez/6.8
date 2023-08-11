package com.example.a68.data

import org.junit.Assert.*

import org.junit.Test

class MapperTest {

    @Test
    fun toEntity() {
        //Given(dado este valor)
        val url = "http://example.com"
        val id = "cualquiercosa"

        //When(hago esta acción)
        val resultadoTransformacion = url.toEntity(id)

        //Then(espero este resultado)

        assertEquals(id, resultadoTransformacion.razaDetalle)
        assertEquals(url, resultadoTransformacion.url)
    }

    @Test
    fun toRazaEntity() {
        //Given
        val raza = "sionoraza"

        //When
        val resultadotransf = raza.toRazaEntity()

        //Then
        assertEquals(raza, resultadotransf.raza)
    }
}