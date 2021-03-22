package info.igorek.carmanagerfragment.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import info.igorek.carmanagerfragment.data.Car

class CarListViewModel : ViewModel() {
    val carListLiveData = MutableLiveData<MutableList<Car>>(mutableListOf())

    var selectedIndex = MutableLiveData<Int>(0)

    fun selectCar(index: Int) {
        selectedIndex.value = index
    }

    fun loadCars(cars: MutableList<Car>) {
        carListLiveData.value = cars
    }

    fun addCar(car: Car) {
        carListLiveData.value!!.add(car)
    }

    fun getCarAtPosition(position: Int) : Car {
        return carListLiveData.value!![position]
    }

    fun updateCarAtPosition(updatedCar: Car, position: Int) {
        carListLiveData.value!!.set(position, updatedCar)
    }
}