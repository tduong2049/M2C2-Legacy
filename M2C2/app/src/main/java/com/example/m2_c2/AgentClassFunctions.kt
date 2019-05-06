package com.example.m2_c2

import android.content.Context

fun applyEspionageAgent(agent: Agent) {}

fun applyOperationsAgent(agent: Agent) {}

fun applyReconAgent(agent: Agent) {}

fun applyRecruitingAgent(agent: Agent) { agent.strength += agent.allies.size}

fun applyTacticalAgent(agent: Agent) {}

fun applyTechAgent(agent: Agent, context: Context) {
    for (equipment in agent.equipment) {
        when (equipment.name) {
            context.getString(R.string.one_handed) -> { if (equipment.bonus >= 1) agent.strength += 1 }
            context.getString(R.string.two_handed) -> { if (equipment.bonus >= 1) agent.strength += 1 }
        }
    }
}