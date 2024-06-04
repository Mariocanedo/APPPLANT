package com.example.appplant.Modelo

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.appplant.Modelo.Local.Dao.FlowerDao
import com.example.appplant.Modelo.Local.Entities.FlowerDetails
import com.example.appplant.Modelo.Remote.RetrofitFlowers
import com.example.appplant.Modelo.Remote.fromInternetDetailsFlowers
import com.example.appplant.Modelo.Remote.fromInternetListFlowers


class FloweRepository(private val flowerDao: FlowerDao) {


    private val networkService = RetrofitFlowers.getRetrofit()
     val flowerListLiveData = flowerDao.getAllFlowers()


     suspend fun fetchList(){

         // conectarse a internet
          val service =  kotlin.runCatching {networkService.fetchFlowerList()}

         service.onSuccess {
             when (it.code()) {
                 in 200..299 -> it.body()?.let {
                Log.d("Flowers",it.toString())
                     flowerDao.inserAllFlowers(fromInternetListFlowers(it))
               }
                 else -> Log.d("Repo","${it.code()}-- ${it.errorBody()}")

}
             service.onFailure{
                     Log.e("Error","${it.message}" )
             }
         }
     }


    suspend fun fetchFlowerDetails(id: Int): FlowerDetails? {
        // conectarse a internet
        val service = kotlin.runCatching { networkService.fetchFlowersDetail(id) }
        return service.getOrNull()?.body()?.let {

                Details ->

            val flowerDetails = fromInternetDetailsFlowers(Details)
            flowerDao.insertFlowersDetail(flowerDetails)
            flowerDetails

        }

    }


    fun getFlowerDetailsById(id:Int) :LiveData<FlowerDetails>{
        return flowerDao.getFlowersDetailById(id)
    }



}








