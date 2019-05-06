package com.example.m2_c2

import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.ally_view.view.*

class AgentAllyAdapter(private val agent: Agent) : RecyclerView.Adapter<AgentAllyAdapter.AllyViewHolder>() {

    override fun getItemCount() = agent.allies.size

    class AllyViewHolder(val allyView: View): RecyclerView.ViewHolder(allyView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.ally_view, parent, false)

        return AllyViewHolder(itemView)
    }

    override fun onBindViewHolder(allyViewHolder: AllyViewHolder, index: Int) {
        val ally: Ally = agent.allies[index]

        allyViewHolder.allyView.allyName_text.text = ally.name
        allyViewHolder.allyView.allyName_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)

        allyViewHolder.allyView.allyBonus_text.text = ally.bonus.toString()
        allyViewHolder.allyView.allyBonus_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
    }
}