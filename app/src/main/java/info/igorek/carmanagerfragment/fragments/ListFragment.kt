package info.igorek.carmanagerfragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.igorek.carmanagerfragment.R
import info.igorek.carmanagerfragment.adapters.CarListAdapter
import info.igorek.carmanagerfragment.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {

    private var _binding : FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var carListAdapter: CarListAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }
}