package com.example.m2_c2

import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.power_view.view.*

class AgentPowerAdapter(private val agent: Agent) : RecyclerView.Adapter<AgentPowerAdapter.PowerViewHolder>() {

    override fun getItemCount() = agent.powers.size

    class PowerViewHolder(val powerView: View): RecyclerView.ViewHolder(powerView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PowerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.power_view, parent, false)

        return PowerViewHolder(itemView)
    }

    override fun onBindViewHolder(powerViewHolder: PowerViewHolder, index: Int) {
        val power: Power = agent.powers[index]

        powerViewHolder.powerView.powerName_text.text = power.name
        powerViewHolder.powerView.powerName_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)

        powerViewHolder.powerView.powerBonus_text.text = power.bonus.toString()
        powerViewHolder.powerView.powerBonus_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)

        powerViewHolder.powerView.powerRank_text.text = power.rank.toString()
        powerViewHolder.powerView.powerRank_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
    }
}