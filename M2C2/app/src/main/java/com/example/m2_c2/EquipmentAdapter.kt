package com.example.m2_c2

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.equipment_view.view.*
import org.jetbrains.anko.backgroundColor

// Adapter for passing information from a list of Equipment objects to a Recyclerview that will display every
// object from the list.
class EquipmentAdapter(private val equipmentList: MutableList<Equipment>) :
    RecyclerView.Adapter<EquipmentAdapter.EquipmentViewHolder>() {

    // The recycler must know how many objects are in the list to ensure that they can all be displayed
    override fun getItemCount() = equipmentList.size

    // Create a custom view holder class that will hold Equipment views
    class EquipmentViewHolder(val equipmentView: View): RecyclerView.ViewHolder(equipmentView)

    // When the Equipment View Holder is created, inflate the corresponding layout for displaying an Equipment
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipmentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.equipment_view, parent, false)

        return EquipmentViewHolder(itemView)
    }

    // Within the Equipment View Holder, display the visible equipment's name, bonus, and gold value.
    // When the item is selected by the user, darken the background for that row to indicate that it was been selected.
    // Set the flag within the Equipment to indicate that it was selected or deselected
    override fun onBindViewHolder(equipmentViewHolder: EquipmentViewHolder, index: Int) {
        val equipment: Equipment = equipmentList[index]

        equipmentViewHolder.equipmentView.equipmentName_text.text = equipment.name
        equipmentViewHolder.equipmentView.equipmentBonus_text.text = equipment.bonus.toString()
        equipmentViewHolder.equipmentView.equipmentGoldValue_text.text = equipment.goldValue.toString()

        if (equipment.isSelected) {
            equipmentViewHolder.equipmentView.backgroundColor = Color.LTGRAY
        }
        else {
            equipmentViewHolder.equipmentView.backgroundColor = Color.WHITE
        }

        equipmentViewHolder.equipmentView.setOnClickListener {
            equipment.isSelected = !equipment.isSelected

            if (equipment.isSelected) {
                equipmentViewHolder.equipmentView.backgroundColor = Color.LTGRAY
            }
            else {
                equipmentViewHolder.equipmentView.backgroundColor = Color.WHITE
            }
        }// end Click Listener
    }// end Bind View Holder function
}// end Equipment Adapter class