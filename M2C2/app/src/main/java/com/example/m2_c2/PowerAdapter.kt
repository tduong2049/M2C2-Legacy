package com.example.m2_c2

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.power_view.view.*
import org.jetbrains.anko.backgroundColor

// Adapter for passing information from a list of Power objects to a Recyclerview that will display every
// object from the list.
class PowerAdapter(private val powerList: MutableList<Power>) : RecyclerView.Adapter<PowerAdapter.PowerViewHolder>() {

    // The recycler must know how many objects are in the list to ensure that they can all be displayed
    override fun getItemCount() = powerList.size

    // Create a custom view holder class that will hold Power views
    class PowerViewHolder(val powerView: View): RecyclerView.ViewHolder(powerView)

    // When the Power View Holder is created, inflate the corresponding layout for displaying a Power
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PowerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.power_view, parent, false)

        return PowerViewHolder(itemView)
    }

    // Within the Power View Holder, display the visible Power's name, bonus, and rank requirement.
    // When the item is selected by the user, darken the background for that row to indicate that it was been selected.
    // Set the flag within the Power to indicate that it was selected or deselected
    override fun onBindViewHolder(powerViewHolder: PowerViewHolder, index: Int) {
        val power: Power = powerList[index]

        powerViewHolder.powerView.powerName_text.text = power.name
        powerViewHolder.powerView.powerBonus_text.text = power.bonus.toString()
        powerViewHolder.powerView.powerRank_text.text = power.rank.toString()

        if (power.isSelected) {
            powerViewHolder.powerView.backgroundColor = Color.LTGRAY
        }
        else {
            powerViewHolder.powerView.backgroundColor = Color.WHITE
        }

        powerViewHolder.powerView.setOnClickListener {
            power.isSelected = !power.isSelected

            if (power.isSelected) {
                powerViewHolder.powerView.backgroundColor = Color.LTGRAY
            }
            else {
                powerViewHolder.powerView.backgroundColor = Color.WHITE
            }
        }// end Click Listener
    }// end Bind View Holder function
}// end Power Adapter class