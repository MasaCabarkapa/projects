package com.example.theatreApp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.theatreApp.R

class AboutFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        tvTitle.text = "O pozoristu"

        val tvDescription = view.findViewById<TextView>(R.id.tvDescription)
        tvDescription.text = "Srpsko narodno pozorište je osnovano 16/28. jula 1861. godine u Novom Sadu, u tadašnjoj Carevini Austriji (od 1867. Austrougarska monarhija). U Vojvodini je do tada već postojala duga pozorišna tradicija, od đačkih diletantskih predstava, pa sve do privatnih profesionalnih pozorišnih trupa. Pozorište je osnivano u vreme buđenja nacionalne svesti i borbe za nacionalnu slobodu. U to doba u Novom Sadu većina žitelja je srpske narodnosti, veliki broj je visokoobrazovan, tri četvrtine imanja i trgovina bili su u rukama Srba, tako da nije slučajno što je u Novom Sadu osnovano Srpsko narodno pozorište."


        return view
    }

}