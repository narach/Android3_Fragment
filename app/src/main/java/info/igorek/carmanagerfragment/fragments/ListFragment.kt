package info.igorek.carmanagerfragment.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import info.igorek.carmanagerfragment.R
import info.igorek.carmanagerfragment.adapters.CarListAdapter
import info.igorek.carmanagerfragment.data.Car
import info.igorek.carmanagerfragment.databinding.FragmentListBinding
import info.igorek.carmanagerfragment.viewmodels.CarListViewModel

class ListFragment : Fragment(R.layout.fragment_list) {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var carListAdapter: CarListAdapter
    private lateinit var fContext: Context
    private val carListViewModel: CarListViewModel by activityViewModels()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.fContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        carListAdapter = CarListAdapter(carListViewModel.carListLiveData.value!!)

        binding.recyclerViewList.adapter = carListAdapter
        binding.recyclerViewList.layoutManager = LinearLayoutManager(fContext)

        carListViewModel.carListLiveData.observe(
            viewLifecycleOwner,
            Observer<MutableList<Car>> {
                carListAdapter.notifyDataSetChanged()
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}