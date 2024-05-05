package com.example.mypetapp

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    //Initialize the variables
    private lateinit var feedButton: Button
    private lateinit var playButton: Button
    private lateinit var cleanButton: Button

    private lateinit var textHunger: TextView
    private lateinit var textClean: TextView
    private lateinit var textHappy: TextView
    private lateinit var image: ImageView

    //Initialize the TextViews
    private var hunger = 50
    private var clean  = 50
    private var happy  = 50



    @SuppressLint("SetTextI18n")
    private fun Update() {

        //Declaring the TextViews
        val textHunger = findViewById<TextView>(R.id.textHunger)
        val textClean = findViewById<TextView>(R.id.textClean)
        val textHappy = findViewById<TextView>(R.id.textHappy)

        textHunger.text = "Hunger: $hunger"
        textClean.text = "Clean: $clean"
        textHappy.text = "Happy: $happy"
    }


    private fun feedPet() {
        clean -= 10
        hunger -= 10
        if (clean < 0) clean = 0
        if (hunger < 0) hunger = 0
        if (hunger == 0) {
            Toast.makeText(this, "Your pet is no longer hungry", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cleanPet() {
        happy -= 10
        if (happy < 0) happy = 0
        if (clean < 0) clean = 0
        if (clean < 100) clean += 10
        if (clean == 100) {
            Toast.makeText(this, "Your pet is cleaned", Toast.LENGTH_SHORT).show()
        }
    }

    private fun playPet() {
        hunger += 10
        clean -= 10
        if (clean < 0) clean = 0
        if (hunger > 100) hunger = 100
        if (happy < 0) happy = 0
        if (happy < 100) happy += 10
        if (happy == 100) {
            Toast.makeText(this, "Your pet have played enough", Toast.LENGTH_SHORT).show()
        }
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        //Declaration of the Buttons
        val feedButton = findViewById<Button>(R.id.feedButton)
        val playButton = findViewById<Button>(R.id.playButton)
        val cleanButton = findViewById<Button>(R.id.cleanButton)

        val image = findViewById<ImageView>(R.id.NormalImage)


        //Initialisation of  the Feed Button
        feedButton.setOnClickListener {
            Log.i("buttonClicked","Feed button clicked")
                feedPet()
                Update()
            //make the image change
            image.setImageResource(R.drawable.feed)
                }

        //Initialisation of  the Play Button
        playButton.setOnClickListener {
            Log.i("buttonClicked","Play button clicked")
                playPet()
                Update()

            //make the image change
            image.setImageResource(R.drawable.play)
                }

        //Initialisation of  the Clean  Button
        cleanButton.setOnClickListener {
            Log.i("buttonClicked","Clean button clicked")
                cleanPet()
                Update()

            //make the image change
            image.setImageResource(R.drawable.clean)
                }

        }
    }
