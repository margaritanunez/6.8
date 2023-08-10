package com.example.a68.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RazaPerrosEntity::class, RazaDetalleEntity::class], version = 1)
abstract class RazaPerrosDataBase : RoomDatabase() {
    abstract fun getRazaDao(): RazaPerrosDao

    companion object{
        @Volatile
        private var INSTANCE: RazaPerrosDataBase? = null

        fun getDatabase(context: Context): RazaPerrosDataBase{
            val tempInstance = INSTANCE
            if (tempInstance !=null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RazaPerrosDataBase::class.java,
                    "razas_database"
                ).build()

            INSTANCE = instance
            return instance
            }
        }
    }
}