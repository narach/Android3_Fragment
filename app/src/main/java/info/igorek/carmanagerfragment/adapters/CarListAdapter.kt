package info.igorek.carmanagerfragment.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.igorek.carmanagerfragment.data.Car

class CarListAdapter(private var carsList : List<Car>) : RecyclerView.Adapter<CarListAdapter.CarViewHolder>() {
    inner class CarViewHolder(carView : View) : RecyclerView.ViewHolder(carView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}