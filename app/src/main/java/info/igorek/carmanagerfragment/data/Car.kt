package info.igorek.carmanagerfragment.data

import android.graphics.drawable.Drawable

data class Car(
    val image: Drawable?,
    val brand: String,
    val model: String,
    val year: String
)