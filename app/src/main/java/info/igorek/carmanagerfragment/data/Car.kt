package info.igorek.carmanagerfragment.data

import android.graphics.drawable.Drawable

data class Car(
    var image: Drawable?,
    var brand: String,
    var model: String,
    var year: String
)