package com.example.theatreApp.adapters

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.theatreApp.R
import com.example.theatreApp.models.Actor
import com.example.theatreApp.models.Event
import java.time.LocalDate
import java.time.Period

class ActorsRecyclerAdapter (private val eventsList: List<Actor>)
    : RecyclerView.Adapter<ActorsRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        //layout resource file that needs to be inflated,reference to the parent view to which the inflated layout will be attached
        return ViewHolder(v) //kesira podatke da rv ne mora da ih trazi svaki put
        //da postavi list item na RV
    }

    override fun getItemCount(): Int {
        Log.e("m", eventsList.size.toString())
        return eventsList.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemWhen.text = """${eventsList[position].firstName} ${eventsList[position].lastName}"""
        holder.itemWhat.text = Period.between(LocalDate.parse(eventsList[position].dateOfBirth), LocalDate.now()).years.toString() + " godina, " + eventsList[position].city

        Log.e("constr", eventsList.toString())
        //povezuje podatke sa ViewHolderom
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemWhen: TextView
        var itemWhat: TextView

        init {
            itemWhen = itemView.findViewById(R.id.tvWhen)
            itemWhat = itemView.findViewById(R.id.tvWhat)
        }
    }
}