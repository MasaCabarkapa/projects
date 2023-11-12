package com.example.theatreApp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.theatreApp.R
import com.example.theatreApp.adapters.ActorsRecyclerAdapter
import com.example.theatreApp.adapters.EventsRecyclerAdapter
import com.example.theatreApp.firestore.Firestore
import com.example.theatreApp.models.Actor
import com.example.theatreApp.models.Event

class EventsFragment : Fragment() {
    private val firestore = Firestore()
    private var events: List<Event> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_events, container, false)

        firestore.getEvents().addOnSuccessListener { documents ->
            try {

                events = documents.toObjects(Event::class.java)
            } finally {

            }

            val recyclerView = view.findViewById<RecyclerView>(R.id.rvEvents)
            recyclerView.adapter = EventsRecyclerAdapter(events)

        }.addOnFailureListener {
            Toast.makeText(context, "Events not loaded", Toast.LENGTH_LONG).show()
        }




        return view
    }
}