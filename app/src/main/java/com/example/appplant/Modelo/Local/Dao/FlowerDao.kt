package com.example.appplant.Modelo.Local.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Index
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appplant.Modelo.Local.Entities.FlowerDetails
import com.example.appplant.Modelo.Local.Entities.FlowerList


@Dao
interface FlowerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserAllFlowers( flowerList:List<FlowerList>)

    @Query("SELECT * FROM List_Flowers ORDER BY id ASC")
     fun getAllFlowers(): LiveData<List<FlowerList>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlowersDetail( flowerList:FlowerDetails)

    @Query("SELECT * FROM Details_Flowers WHERE id = :id")
    fun getFlowersDetailById(id:Int): LiveData<FlowerDetails>

}