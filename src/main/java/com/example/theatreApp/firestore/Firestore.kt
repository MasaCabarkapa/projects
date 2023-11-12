package com.example.theatreApp.firestore;

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Firestore {
    private val mFireStore = Firebase.firestore

    fun getEvents() : Task<QuerySnapshot> {
        return mFireStore.collection("events").get()
    }

    fun getActors() : Task<QuerySnapshot> {
        return mFireStore.collection("actors").get()
    }
}
