package app.shoppingproject_kotlin.product

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import app.shoppingproject_kotlin.MainActivity
import app.shoppingproject_kotlin.R
import app.shoppingproject_kotlin.adapter.CategoryAdapter
import app.shoppingproject_kotlin.adapter.ProductListAdatper
import app.shoppingproject_kotlin.model.CategoryDao
import app.shoppingproject_kotlin.databinding.ProductFragmentBinding
import app.shoppingproject_kotlin.model.ProductListDao

class ProductFragment : Fragment() {

    lateinit var mainActivity: MainActivity
    lateinit var binding : ProductFragmentBinding

    lateinit var categoryAdapter : CategoryAdapter
    lateinit var pListAdapter : ProductListAdatper

    var categoryItem = mutableListOf<CategoryDao>()
    var pListItem = mutableListOf<ProductListDao>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) mainActivity = context

        categoryAdapter = CategoryAdapter(context)
        pListAdapter = ProductListAdatper(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Setting the Category Adapter for Using

        binding = DataBindingUtil.inflate(inflater, R.layout.product_fragment, container, false)

        binding.productFragCategoryRecyclerView.adapter = categoryAdapter
        binding.productFragCategoryRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        categoryAdapter.datas = categoryItem

        binding.productFragListRecyclerView.adapter = pListAdapter
        binding.productFragListRecyclerView.layoutManager = GridLayoutManager(context, 2)
        pListAdapter.datas = pListItem


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Add Items
        categoryItem.apply {
            add(CategoryDao(img = R.drawable.category_all_icon, title = "전체"))
            add(CategoryDao(img = R.drawable.category_shirts_icon, title = "상의"))
            add(CategoryDao(img = R.drawable.category_pants, title = "하의"))
            add(CategoryDao(img = R.drawable.category_shoes, title = "신발"))
            add(CategoryDao(img = R.drawable.category_cap, title = "모자"))
            add(CategoryDao(img = R.drawable.category_jewely, title = "악세서리"))
            categoryAdapter.notifyDataSetChanged()
        }

        pListItem.apply {
            TODO("상품리스트 아이템 추가")
            pListAdapter.notifyDataSetChanged()
        }
    }
}