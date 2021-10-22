package app.shoppingproject_kotlin.product

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import app.shoppingproject_kotlin.R
import app.shoppingproject_kotlin.databinding.DetailActivityBinding
import app.shoppingproject_kotlin.product.adapter.DetailViewPagerAdapter

class DetailActivity : AppCompatActivity() {
    lateinit var binding : DetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<DetailActivityBinding>(this, R.layout.detail_activity)

        //Import Adapter
        binding.detailViewPager.adapter = DetailViewPagerAdapter(getViewPagerItemList())
        //Set Orientation(Horizon)
        binding.detailViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

    }

    private fun getViewPagerItemList() : ArrayList<Drawable> {
        val list = ArrayList<Drawable>()
        //TODO getDrawable by Firebase Storage and list.add(it)
        return list
    }
}