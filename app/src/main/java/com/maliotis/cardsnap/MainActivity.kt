package com.maliotis.cardsnap

import android.content.res.Resources.getSystem
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.setPadding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    val data = IntArray(30) { (it + 1) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        var adapter = RecyclerViewAdapter(data.toMutableList())
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val scaleLinearLayoutManager = ScaleLinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        // button
        val button = findViewById<MaterialButton>(R.id.layoutButton)
        button.setOnClickListener {
            // Below is needed if you switch layouts
            if (recyclerView.layoutManager is ScaleLinearLayoutManager) {
                recyclerView.layoutManager = linearLayoutManager
                button.text = "Scale up"
                // forces recyclerView to redraw all views
                adapter = RecyclerViewAdapter(data.toMutableList())
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()

            } else {
                recyclerView.layoutManager = scaleLinearLayoutManager
                button.text = "Scale down"
                // forces recyclerView to redraw all views
                adapter = RecyclerViewAdapter(data.toMutableList())
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }
    }
}