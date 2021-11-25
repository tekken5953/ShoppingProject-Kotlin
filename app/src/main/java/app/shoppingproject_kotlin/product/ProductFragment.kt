package app.shoppingproject_kotlin.product

import android.content.Context
import android.icu.lang.UCharacter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import app.shoppingproject_kotlin.MainActivity
import app.shoppingproject_kotlin.R
import app.shoppingproject_kotlin.adapter.ProductListAdatper
import app.shoppingproject_kotlin.databinding.ProductFragmentBinding
import app.shoppingproject_kotlin.model.ProductListDao

class ProductFragment : Fragment() {

    lateinit var mainActivity: MainActivity
    lateinit var binding : ProductFragmentBinding

    lateinit var pListAdapter : ProductListAdatper

    var pListItem = mutableListOf<ProductListDao>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) mainActivity = context

        pListAdapter = ProductListAdatper(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Setting the Category Adapter for Using

        binding = DataBindingUtil.inflate(inflater, R.layout.product_fragment, container, false)

        binding.productListRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.productListRecyclerView.adapter = pListAdapter
        binding.productListRecyclerView.layoutManager = StaggeredGridLayoutManager(2,0)
        pListAdapter.datas = pListItem


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pListItem.apply {
            pListAdapter.notifyDataSetChanged()
        }
    }
}