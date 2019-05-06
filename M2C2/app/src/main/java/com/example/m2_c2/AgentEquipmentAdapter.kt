package com.example.m2_c2

import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.equipment_view.view.*

class AgentEquipmentAdapter(private val agent: Agent) : RecyclerView.Adapter<AgentEquipmentAdapter.EquipmentViewHolder>() {

    override fun getItemCount() = agent.equipment.size

    class EquipmentViewHolder(val equipmentView: View): RecyclerView.ViewHolder(equipmentView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipmentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.equipment_view, parent, false)

        return EquipmentViewHolder(itemView)
    }

    override fun onBindViewHolder(equipmentViewHolder: EquipmentViewHolder, index: Int) {
        val equipment: Equipment = agent.equipment[index]

        equipmentViewHolder.equipmentView.equipmentName_text.text = equipment.name
        equipmentViewHolder.equipmentView.equipmentName_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)

        equipmentViewHolder.equipmentView.equipmentBonus_text.text = equipment.bonus.toString()
        equipmentViewHolder.equipmentView.equipmentBonus_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)

        equipmentViewHolder.equipmentView.equipmentGoldValue_text.text = equipment.goldValue.toString()
        equipmentViewHolder.equipmentView.equipmentGoldValue_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
    }
}