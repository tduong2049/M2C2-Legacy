package com.example.m2_c2

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.ally_view.view.*
import org.jetbrains.anko.backgroundColor

// The Ally Adapter is based off the Equipment Ally. Since Ally cards do not have a gold value, only their name and
// bonus is displayed.
class AllyAdapter(private val allyList: MutableList<Ally>) : RecyclerView.Adapter<AllyAdapter.AllyViewHolder>() {

    override fun getItemCount() = allyList.size

    class AllyViewHolder(val allyView: View): RecyclerView.ViewHolder(allyView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.ally_view, parent, false)

        return AllyViewHolder(itemView)
    }

    override fun onBindViewHolder(allyViewHolder: AllyViewHolder, index: Int) {
        val ally: Ally = allyList[index]

        allyViewHolder.allyView.allyName_text.text = ally.name
        allyViewHolder.allyView.allyBonus_text.text = ally.bonus.toString()

        if (ally.isSelected) {
            allyViewHolder.allyView.backgroundColor = Color.LTGRAY
        }
        else {
            allyViewHolder.allyView.backgroundColor = Color.WHITE
        }

        allyViewHolder.allyView.setOnClickListener {
            ally.isSelected = !ally.isSelected

            if (ally.isSelected) {
                allyViewHolder.allyView.backgroundColor = Color.LTGRAY
            }
            else {
                allyViewHolder.allyView.backgroundColor = Color.WHITE
            }
        }
    }
}