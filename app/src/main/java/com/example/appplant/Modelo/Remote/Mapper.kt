package com.example.appplant.Modelo.Remote

import com.example.appplant.Modelo.Local.Entities.FlowerDetails
import com.example.appplant.Modelo.Local.Entities.FlowerList
import com.example.appplant.Modelo.Remote.FromInternet.DetailsFlower
import com.example.appplant.Modelo.Remote.FromInternet.ListFlowers


fun fromInternetListFlowers( flowerList: List<ListFlowers>) : List<FlowerList> {

    return flowerList.map {
        FlowerList(

            id = it.id,
            nombre = it.nombre,
            tipo = it.tipo,
            imagen = it.imagen,
            descripcion = it.descripcion
        )

    }

}
    fun fromInternetDetailsFlowers(detailsFlower: DetailsFlower): FlowerDetails {

        return FlowerDetails(
            id = detailsFlower.id,
            nombre = detailsFlower.nombre,
            tipo = detailsFlower.tipo,
            imagen = detailsFlower.imagen,
            descripcion = detailsFlower.descripcion
        )
    }


