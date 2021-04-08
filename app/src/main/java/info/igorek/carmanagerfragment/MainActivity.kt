package info.igorek.carmanagerfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import info.igorek.carmanagerfragment.data.Car
import info.igorek.carmanagerfragment.databinding.ActivityMainBinding
import info.igorek.carmanagerfragment.databinding.ItemCarBinding
import info.igorek.carmanagerfragment.fragments.AddFragment
import info.igorek.carmanagerfragment.fragments.EditFragment
import info.igorek.carmanagerfragment.fragments.ListFragment
import info.igorek.carmanagerfragment.helpers.InitHelper
import info.igorek.carmanagerfragment.interfaces.CommunicationInterface
import info.igorek.carmanagerfragment.viewmodels.CarListViewModel

class MainActivity : AppCompatActivity(), CommunicationInterface {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentCarList: ListFragment
    private lateinit var fragmentCarEdit: EditFragment
    private lateinit var fragmentCarAdd: AddFragment

    private val carListViewModel: CarListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        carListViewModel.loadCars(InitHelper.initCarList(this))

        fragmentCarList = ListFragment(this)
        fragmentCarEdit = EditFragment(this)
        fragmentCarAdd = AddFragment(this)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuItemList -> setCurrentFragment(fragmentCarList)
                R.id.menuItemEdit -> setCurrentFragment(fragmentCarEdit)
                R.id.menuItemAdd -> setCurrentFragment(fragmentCarAdd)

            }
            true
        }

        setCurrentFragment(fragmentCarList)
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayoutFragment, fragment)
            commit()
        }
    }

    override fun createCar() {
        binding.bottomNavigationView.selectedItemId = R.id.menuItemAdd
//        setCurrentFragment()
    }

    override fun updateCar(index: Int) {
        carListViewModel.selectCar(index)
        binding.bottomNavigationView.selectedItemId = R.id.menuItemEdit
        setCurrentFragment(fragmentCarEdit)
    }

    override fun listCars() {
        binding.bottomNavigationView.selectedItemId = R.id.menuItemList
        setCurrentFragment(fragmentCarList)
    }

    override fun onCarCreated(car: Car?) {
        TODO("Not yet implemented")
    }
}