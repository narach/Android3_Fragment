package info.igorek.carmanagerfragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import info.igorek.carmanagerfragment.R
import info.igorek.carmanagerfragment.databinding.FragmentAddBinding
import info.igorek.carmanagerfragment.interfaces.CommunicationInterface

class AddFragment(private val navigation: CommunicationInterface) : Fragment(R.layout.fragment_add) {

    private lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAdd.setOnClickListener {
            Toast.makeText(activity, "TEMPORARY MESSAGE", Toast.LENGTH_SHORT).show()
        }
    }
}