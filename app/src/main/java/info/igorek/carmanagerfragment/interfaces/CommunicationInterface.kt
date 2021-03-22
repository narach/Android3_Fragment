package info.igorek.carmanagerfragment.interfaces

import info.igorek.carmanagerfragment.data.Car

interface CommunicationInterface {
    fun createCar()
    fun updateCar(index: Int)
    fun listCars()
    fun onCarCreated(car: Car?)
}