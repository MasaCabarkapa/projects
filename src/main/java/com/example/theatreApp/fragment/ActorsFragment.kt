package com.example.theatreApp.fragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.theatreApp.R
import com.example.theatreApp.adapters.ActorsRecyclerAdapter
import com.example.theatreApp.adapters.EventsRecyclerAdapter
import com.example.theatreApp.firestore.Firestore
import com.example.theatreApp.models.Actor
import com.example.theatreApp.models.Event
import java.time.LocalDate

class ActorsFragment : Fragment() {

    private val firestore = Firestore()
    private var actors: List<Actor> = arrayListOf()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_actors, container, false)

        firestore.getActors().addOnSuccessListener { documents ->
            try {

            actors = documents.toObjects(Actor::class.java)
            } finally {

            }
            val recyclerView = view.findViewById<RecyclerView>(R.id.rvActors)
            recyclerView.adapter = ActorsRecyclerAdapter(actors)

        }.addOnFailureListener {
            Toast.makeText(context, "Actors not loaded", Toast.LENGTH_LONG).show()
        }

        return view
    }

}