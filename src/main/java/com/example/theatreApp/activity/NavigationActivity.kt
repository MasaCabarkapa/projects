package com.example.theatreApp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.theatreApp.R
import com.example.theatreApp.firestore.Firestore
import com.example.theatreApp.fragment.AboutFragment
import com.example.theatreApp.fragment.ActorsFragment
import com.example.theatreApp.fragment.EventsFragment


class NavigationActivity : AppCompatActivity() {

    private val firestore: Firestore = Firestore()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        val moreInfo = findViewById<ImageView>(R.id.imageMoreInfo)

        moreInfo.setOnClickListener {
            startActivity(
                Intent(this, MoreInfoActivity::class.java)
            )
        }

        val logOut = findViewById<ImageView>(R.id.imageLogOut)
        logOut.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        val btnEvents: Button = findViewById(R.id.btnEvents)
        btnEvents.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frame, EventsFragment()).commit()
        }

        val btnActors: Button = findViewById(R.id.btnActors)
        btnActors.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frame, ActorsFragment()).commit()
        }

        val btnAbout: Button = findViewById(R.id.btnAbout)
        btnAbout.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frame, AboutFragment()).commit()
        }

    }
}