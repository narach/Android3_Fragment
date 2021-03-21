package info.igorek.carmanagerfragment.helpers

import android.content.Context
import androidx.core.content.ContextCompat
import info.igorek.carmanagerfragment.R
import info.igorek.carmanagerfragment.data.Car

object InitHelper {
    fun initCarList(context: Context): MutableList<Car> {
        return mutableListOf(
            Car(
                ContextCompat.getDrawable(context, R.drawable.tesla_model_s_2018),
                "Tesla",
                "Model S",
                "2018"
            ),
            Car(
                ContextCompat.getDrawable(context, R.drawable.lexus_nx300h_2014),
                "Lexus",
                "NX300h",
                "2014"
            ),
            Car(
                ContextCompat.getDrawable(context, R.drawable.chevrolet_camaro_2019),
                "Chevrolet",
                "Camaro",
                "2019"
            ),
        )
    }
}