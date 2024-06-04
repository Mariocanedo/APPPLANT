package com.example.appplant.Modelo.Local.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appplant.Modelo.Local.Dao.FlowerDao
import com.example.appplant.Modelo.Local.Entities.FlowerDetails
import com.example.appplant.Modelo.Local.Entities.FlowerList


@Database(entities = [FlowerList::class,FlowerDetails::class],version=1)
abstract class FlowerDatabase : RoomDatabase(){

    //referencia al dao
    abstract fun getFlowerDao(): FlowerDao

    companion object {
        @Volatile
        private var INSTANCE: FlowerDatabase? = null

        fun getDataBase(context: Context): FlowerDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FlowerDatabase::class.java,
                    "Flowers_database"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }




}