package app.shoppingproject_kotlin.product

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import app.shoppingproject_kotlin.MainActivity
import app.shoppingproject_kotlin.R
import app.shoppingproject_kotlin.product.adapter.CategoryAdapter
import app.shoppingproject_kotlin.product.model.CategoryItem
import app.shoppingproject_kotlin.databinding.ProductFragmentBinding

class ProductFragment : Fragment() {

    lateinit var mainActivity: MainActivity
    lateinit var binding : ProductFragmentBinding

    lateinit var categoryAdapter : CategoryAdapter
    var categoryItem = mutableListOf<CategoryItem>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) mainActivity = context

        categoryAdapter = CategoryAdapter(context)
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Add Items
        categoryItem.apply {
            add(CategoryItem(img = R.drawable.category_all_icon, title = "전체"))
            add(CategoryItem(img = R.drawable.category_shirts_icon, title = "상의"))
        }
        categoryAdapter.notifyDataSetChanged()
    }

}