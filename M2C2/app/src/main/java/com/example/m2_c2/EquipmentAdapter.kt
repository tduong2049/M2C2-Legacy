package com.example.m2_c2

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.equipment_view.view.*
import org.jetbrains.anko.backgroundColor
import org.w3c.dom.Text

class EquipmentAdapter(private val equipmentList: MutableList<Equipment>) :
    RecyclerView.Adapter<EquipmentAdapter.EquipmentViewHolder>() {

    override fun getItemCount() = equipmentList.size

    class EquipmentViewHolder(val equipmentView: View): RecyclerView.ViewHolder(equipmentView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipmentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.equipment_view, parent, false)

        return EquipmentViewHolder(itemView)
    }

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
        }
    }
}