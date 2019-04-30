package com.example.m2_c2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.equipment_view.view.*
import org.w3c.dom.Text

class EquipmentAdapter(private val equipmentList: MutableList<Equipment>) :
    RecyclerView.Adapter<EquipmentAdapter.EquipmentViewHolder>() {

    class EquipmentViewHolder(val equipmentView: View): RecyclerView.ViewHolder(equipmentView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipmentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.equipment_view, parent, false)

        return EquipmentViewHolder(itemView)
    }

    override fun getItemCount() = equipmentList.size

    override fun onBindViewHolder(equipmentViewHolder: EquipmentViewHolder, index: Int) {
        equipmentViewHolder.equipmentView.equipmentName_text.text = equipmentList[index].name
        equipmentViewHolder.equipmentView.equipmentBonus_text.text = equipmentList[index].bonus.toString()
        equipmentViewHolder.equipmentView.equipmentGoldValue_text.text = equipmentList[index].goldValue.toString()

    }
}