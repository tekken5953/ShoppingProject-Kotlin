package app.shoppingproject_kotlin.product.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.shoppingproject_kotlin.product.model.CategoryItem
import app.shoppingproject_kotlin.R
import com.bumptech.glide.Glide

class CategoryAdapter(private val context: Context) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    var datas = mutableListOf<CategoryItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.model_home_category,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title: TextView = itemView.findViewById(R.id.home_category_title)
        private val img: ImageView = itemView.findViewById(R.id.home_category_img)

        fun bind(item: CategoryItem) {
            title.text = item.title
            Glide.with(context).load(item.img).into(img)

        }
    }


}