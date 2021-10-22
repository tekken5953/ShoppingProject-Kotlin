package app.shoppingproject_kotlin.product.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import app.shoppingproject_kotlin.R

class DetailViewPagerAdapter(mList: ArrayList<Drawable>) :
    RecyclerView.Adapter<DetailViewPagerAdapter.PageViewHolder>() {
    var item = mList

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailViewPagerAdapter.PageViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: DetailViewPagerAdapter.PageViewHolder, position: Int) {
        holder.img.setImageDrawable(item[position])
    }

    override fun getItemCount(): Int = item.size

    inner class PageViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (
        LayoutInflater.from(parent.context).inflate(R.layout.model_viewpager2_item, parent, false)
    ) {
        val img = itemView.findViewById<ImageView>(R.id.viewpager_model_iv)!!
    }
}