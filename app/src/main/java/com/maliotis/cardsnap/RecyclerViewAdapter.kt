package com.maliotis.cardsnap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView

class RecyclerViewAdapter(
    private val data: MutableList<Int>
): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    lateinit var recyclerView: RecyclerView

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: MaterialTextView
        val cardView: MaterialCardView

        init {
            textView = view.findViewById(R.id.item_text)
            cardView = view.findViewById(R.id.card)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        val holder = ViewHolder(view)

        // change margin when scaling so that the edge of the cards are showing
        if (recyclerView.layoutManager is ScaleLinearLayoutManager) {
            holder.cardView.layoutParams.setMargin(0.dp)
        } else {
            holder.cardView.layoutParams.setMargin(36.dp)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = data[position].toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }

}

