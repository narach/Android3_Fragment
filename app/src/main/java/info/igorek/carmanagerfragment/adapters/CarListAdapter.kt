package info.igorek.carmanagerfragment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.igorek.carmanagerfragment.data.Car
import info.igorek.carmanagerfragment.databinding.ItemCarBinding
import info.igorek.carmanagerfragment.interfaces.CommunicationInterface

class CarListAdapter(private var carsList : List<Car>, private val navigation: CommunicationInterface) : RecyclerView.Adapter<CarListAdapter.CarViewHolder>() {
    inner class CarViewHolder(private val itemCarBinding: ItemCarBinding) : RecyclerView.ViewHolder(itemCarBinding.root) {
        fun bind (car : Car) {
            itemCarBinding.imageViewPhoto.setImageDrawable(car.image)
            itemCarBinding.textViewBrand.text = car.brand
            itemCarBinding.textViewModel.text = car.model
            itemCarBinding.textViewYear.text = car.year
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemCarBinding = ItemCarBinding.inflate(layoutInflater, parent, false)
        return CarViewHolder(itemCarBinding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(carsList[position])
        holder.itemView.setOnClickListener {
            navigation.updateCar(position)
        }
    }

    override fun getItemCount(): Int {
        return carsList.size
    }
}