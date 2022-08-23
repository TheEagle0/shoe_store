package com.udacity.shoestore.shoes_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.shoes_item.view.*

class ShoesAdapter(private val shoesList:MutableList<Shoe>): RecyclerView.Adapter<ShoesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.shoes_item, parent, false)

        return ViewHolder(view)    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoe=shoesList[position]
        with(holder.itemView){
            name.text=shoe.name
            desc.text=shoe.description
            size.text=shoe.size.toString()
            company.text=shoe.company
        }
    }


    override fun getItemCount(): Int =shoesList.size

   fun updateList(newList:List<Shoe>){
        shoesList.clear()
       shoesList.addAll(newList)
       notifyDataSetChanged()
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view)
}