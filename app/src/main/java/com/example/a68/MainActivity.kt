package com.example.a68

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/* Lista para una aplicación que utiliza información de una API y que contiene imágenes.
[x] Permiso de internet y clear traffic (o algo así) en Manifest
[x] ViewBinding
[x] Dependencias: Coil, Room, Retrofit, navigation, viewModel. Agregar el plugin de ROOM y cambiar la versión de la 1.8 a la 17
[x] Crear package data, data.local, data.remote y presentation(o vistas)
[x] Remoto:
    [x] Dataclass/ POJO
    [x] API (interfaz)
    [x] Cliente de Retrofit
[ ] Repositorio
[ ] Local:
    [x] Entity
    [x] DAO
    [x] Database
[x] View Model
[ ] 2 pantallas: Listado y detalle
[ ] Navigation
[ ] Listado: RecyclerView + ViewHolder + Adapter
[ ] Detalle: RecyclerView + ViewHolder + Adapter
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}