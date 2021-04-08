package info.igorek.carmanagerfragment.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import info.igorek.carmanagerfragment.R
import info.igorek.carmanagerfragment.adapters.CarListAdapter
import info.igorek.carmanagerfragment.data.Car
import info.igorek.carmanagerfragment.databinding.FragmentEditBinding
import info.igorek.carmanagerfragment.databinding.FragmentListBinding
import info.igorek.carmanagerfragment.helpers.UriToDrawableConverter
import info.igorek.carmanagerfragment.interfaces.CommunicationInterface
import info.igorek.carmanagerfragment.viewmodels.CarListViewModel

class EditFragment (private val navigation: CommunicationInterface): Fragment(R.layout.fragment_edit) {

    private var _binding: FragmentEditBinding? = null
    private val binding get() = _binding!!
    private val carListViewModel: CarListViewModel by activityViewModels()
    private var selectedCar: Car = Car(null, "", "", "")
    private var imageUri : Uri? = null
    private val CODE = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectedCar = carListViewModel.getCarAtPosition(carListViewModel.selectedIndex.value!!)

        with(binding) {
            editTextBrand.setText(selectedCar.brand)
            editTextModel.setText(selectedCar.model)
            editTextYear.setText(selectedCar.year)
            imageViewCarEdit.setImageDrawable(selectedCar.image)

            buttonSave.setOnClickListener {
                selectedCar.brand = editTextBrand.text.toString()
                selectedCar.model = editTextModel.text.toString()
                selectedCar.year = editTextYear.text.toString()
                navigation.listCars()

            }
            imageViewCarEdit.setOnClickListener {
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"
                startActivityForResult(intent, CODE)

            }


        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == CODE) {
            imageUri = data?.data
            binding.imageViewCarEdit.setImageURI(imageUri)
            selectedCar.image = UriToDrawableConverter.uriToDrawable(imageUri.toString(), requireContext())
        }
    }
}