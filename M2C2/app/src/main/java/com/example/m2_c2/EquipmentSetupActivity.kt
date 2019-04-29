package com.example.m2_c2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EquipmentSetupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipment_setup)

        val agent: Agent = intent.extras.getSerializable("agent_id") as Agent

        val agentClassText: TextView = findViewById(R.id.agentClass_text)
        val agentSexText: TextView = findViewById(R.id.agentSex_text)
        val agentRankText: TextView = findViewById(R.id.agentRank_text)

        agentClassText.text = "Class: " + agent.name
        agentSexText.text = "Sex: " + agent.sex
        agentRankText.text = "Rank: " + agent.rank.toString()
    }
}