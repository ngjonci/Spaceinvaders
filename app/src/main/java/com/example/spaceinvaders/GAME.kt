package com.example.spaceinvaders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast
//Testttttttttttttt

class GAME : AppCompatActivity() {

    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_botom_anim) }
    private var clicked = false
    private val floatingActionButton1 = findViewById<Button>(R.id.floatingActionButton1)
    private val floatingActionButton2 = findViewById<Button>(R.id.floatingActionButton2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        floatingActionButton1.setOnClickListener {
            onfloatingActionButton()
        }
        floatingActionButton2.setOnClickListener {
            Toast.makeText(this, "RESTART", Toast.LENGTH_SHORT).show()
        }
    }
    private fun onfloatingActionButton() {
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked
    }
    private fun setVisibility(clicked: Boolean) {
        if (!clicked){
            floatingActionButton2.visibility = View.VISIBLE
        }else{
            floatingActionButton2.visibility = View.INVISIBLE
        }
    }
    private fun setAnimation(clicked: Boolean) {
        if (!clicked){
            floatingActionButton2.startAnimation(fromBottom)
            floatingActionButton1.startAnimation(rotateOpen)
        }else {
            floatingActionButton2.startAnimation(toBottom)
            floatingActionButton1.startAnimation(rotateClose)
        }
    }
}

