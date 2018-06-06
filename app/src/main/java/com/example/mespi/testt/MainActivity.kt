package com.example.mespi.testt

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.GravityCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fab.setOnClickListener { view ->
            showC1()
            showC2()

        }
        imageButton3.setOnClickListener { view ->
            val animation = AnimationUtils.loadAnimation(this, R.anim.left_side)
            card1.startAnimation(animation)
            Handler().postDelayed({ card1.visibility = View.GONE }, 600)
        }
        imageButton4.setOnClickListener { view ->
            val animation = AnimationUtils.loadAnimation(this, R.anim.left_side)
            card2.startAnimation(animation)
            Handler().postDelayed({ card2.visibility = View.GONE }, 600)
        }





    }
    fun showC1(){
            card1.visibility = View.VISIBLE
            val animation = AnimationUtils.loadAnimation(this, R.anim.right_side)
            card1.startAnimation(animation)

    }
    fun showC2(){
        card2.visibility = View.VISIBLE
        val animation = AnimationUtils.loadAnimation(this, R.anim.right_side)
        card2.startAnimation(animation)
    }
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun download() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Last build is ??/??/??")
        builder.setMessage("Enjoy")
        builder.setPositiveButton("Download", { dialogInterface: DialogInterface, i: Int ->
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/folderview?id=19zmhGXyk6dvgex0N3TFIklG97hntSvM1"))
            startActivity(i)
        })
        builder.setNegativeButton("Cancel", { dialogInterface: DialogInterface, i: Int ->
        })
        builder.show()
        }
    fun info() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("About developer")
        builder.setMessage("Author of build: saurus280 (it's my nick on Telegram, 4PDA, XDA and other)\n" +
                "\n" +
                "Main developer: xyyx \n" +
                "\n" +
                "Thanks: xyyx, Dmitry-777, XeonDead, psndna88, mkenzo_dev")
        builder.setPositiveButton("Ok", { dialogInterface: DialogInterface, i: Int ->

        })
        builder.show()
    }
}
