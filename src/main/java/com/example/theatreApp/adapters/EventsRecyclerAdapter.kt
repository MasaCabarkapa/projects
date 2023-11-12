package com.example.theatreApp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.theatreApp.R
import com.example.theatreApp.models.Event

class EventsRecyclerAdapter (private val eventsList: List<Event>)
    : RecyclerView.Adapter<EventsRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ViewHolder(v) //kesira podatke da rv ne mora da ih trazi svaki put
        //da postavi list item na RV
    }

    override fun getItemCount(): Int {
        Log.e("m", eventsList.size.toString())
        return eventsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemWhen.text = eventsList[position].`when` + "h"
        holder.itemWhat.text = eventsList[position].what
        holder.itemHowMuch.text= eventsList[position].howMuch + " dinara"

        Log.e("constr", eventsList.toString())
        //povezuje podatke sa ViewHolderom
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemWhen: TextView
        var itemWhat: TextView
        var itemHowMuch: TextView

        init {
            itemWhen = itemView.findViewById(R.id.tvWhen)
            itemWhat = itemView.findViewById(R.id.tvWhat)
            itemHowMuch = itemView.findViewById(R.id.tvHowMuch)
        }
    }
}