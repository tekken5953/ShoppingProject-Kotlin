package app.shoppingproject_kotlin.mypage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import app.shoppingproject_kotlin.MainActivity
import app.shoppingproject_kotlin.R
import app.shoppingproject_kotlin.databinding.MypageFragmentBinding
import app.shoppingproject_kotlin.product.ProductFragment

class MyPageFragment : Fragment() {

    lateinit var mainActivity: MainActivity
    lateinit var binding : MypageFragmentBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) mainActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.mypage_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}