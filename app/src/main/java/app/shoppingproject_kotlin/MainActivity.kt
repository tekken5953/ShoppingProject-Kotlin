package app.shoppingproject_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import app.shoppingproject_kotlin.bucket.BucketFragment
import app.shoppingproject_kotlin.databinding.ActivityMainBinding
import app.shoppingproject_kotlin.mypage.MyPageFragment
import app.shoppingproject_kotlin.product.ProductFragment
import app.shoppingproject_kotlin.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        bottomNav = binding.mainBottomNav
        bottomNav.selectedItemId = R.id.menu_home

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.main_frame, ProductFragment())
        transaction.addToBackStack("Home")
        transaction.commit()

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    onClickBottomNav(0)
                    true
                }
                R.id.menu_search -> {
                    onClickBottomNav(1)
                    true
                }
                R.id.menu_store -> {
                    onClickBottomNav(2)
                    true
                }
                R.id.menu_mypage -> {
                    onClickBottomNav(3)
                    true
                }
                else -> false
            }
        }

    }

    private fun onClickBottomNav(frag: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        when (frag) {
            0 -> {
                transaction.replace(R.id.main_frame, ProductFragment())
                transaction.addToBackStack("Home")
                transaction.commit()
            }

            1 -> {
                transaction.replace(R.id.main_frame, SearchFragment())
                transaction.addToBackStack("Search")
                transaction.commit()
            }

            2 -> {
                transaction.replace(R.id.main_frame, BucketFragment())
                transaction.addToBackStack("Bucket")
                transaction.commit()
            }

            3 -> {
                transaction.replace(R.id.main_frame, MyPageFragment())
                transaction.addToBackStack("MyPage")
                transaction.commit()
            }
        }
    }

}
