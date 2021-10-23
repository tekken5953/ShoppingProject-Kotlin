package app.shoppingproject_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.shoppingproject_kotlin.model.CategoryDao
import app.shoppingproject_kotlin.R
import app.shoppingproject_kotlin.model.ProductListDao
import com.bumptech.glide.Glide

class ProductListAdatper(private val context: Context) : RecyclerView.Adapter<ProductListAdatper.ViewHolder>() {

    var datas = mutableListOf<ProductListDao>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.model_product_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val name: TextView = itemView.findViewById(R.id.model_pitem_name_tv)
        private val price: TextView = itemView.findViewById(R.id.model_pitem_price_tv)
        private val img: ImageView = itemView.findViewById(R.id.model_pitem_iv)

        fun bind(dao: ProductListDao) {
            name.text = dao.name
            price.text = dao.price
            Glide.with(context).load(dao.img).into(img)

        }
    }


}