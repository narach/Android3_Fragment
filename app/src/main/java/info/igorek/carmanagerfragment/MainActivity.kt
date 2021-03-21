package info.igorek.carmanagerfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import info.igorek.carmanagerfragment.databinding.ActivityMainBinding
import info.igorek.carmanagerfragment.databinding.ItemCarBinding
import info.igorek.carmanagerfragment.fragments.AddFragment
import info.igorek.carmanagerfragment.fragments.EditFragment
import info.igorek.carmanagerfragment.fragments.ListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentCarList: ListFragment
    private lateinit var fragmentCarEdit: EditFragment
    private lateinit var fragmentCarAdd: AddFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentCarList = ListFragment()
        fragmentCarEdit = EditFragment()
        fragmentCarAdd = AddFragment()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuItemList -> setCurrentFragment(fragmentCarList)
                R.id.menuItemEdit -> setCurrentFragment(fragmentCarEdit)
//                R.id.menuItemAdd -> setCurrentFragment(fragmentCarAdd)
                R.id.menuItemAdd -> Toast.makeText(this, "No fragment yet", Toast.LENGTH_SHORT)

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
}