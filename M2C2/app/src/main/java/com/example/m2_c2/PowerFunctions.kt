package com.example.m2_c2

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.text.InputType
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

fun applyMasterTactician(agent: Agent, agentStrengthText: TextView, context: Context) {
    agent.strength += 2

    val dialogBuilder = AlertDialog.Builder(context)

    dialogBuilder.setTitle("Master Tactician")
    dialogBuilder.setMessage("Discard a monster card? (Extra +2 Bonus)")

    dialogBuilder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
        Toast.makeText(context, "Extra +2 Bonus", Toast.LENGTH_SHORT).show()
        agent.strength += 2
        agentStrengthText.text = agent.strength.toString()
    })


    dialogBuilder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
        Toast.makeText(context, "No Extra Bonus", Toast.LENGTH_SHORT).show()
    })

    val dialog: AlertDialog = dialogBuilder.create()
    dialog.show()
}

fun applyHeightenedSenses(agent: Agent) { agent.strength += 1 }

fun applySuperStrength(agent: Agent, context: Context) {
    agent.strength += 3

    var remainingEmptyHands: Int = 2

    for(equipment in agent.equipment) {
        when(equipment.type) {
            context.getString(R.string.one_handed) -> remainingEmptyHands -= 1
            context.getString(R.string.two_handed) -> remainingEmptyHands -= 2
        }
    }

    when (remainingEmptyHands) {
        1 -> agent.strength += 1
        2 -> agent.strength += 2
    }
}

fun applyMartialArtist(agent: Agent) { agent.strength += 2}

fun applySuperSpy(agent: Agent) { agent.strength += 1 }

fun applyEnhancedAgility(agent: Agent) { agent.strength += 2 }

fun applySuperSoldier(agent: Agent) {
    agent.strength += 1

    agent.strength += agent.allies.size
}

fun applyMasterMarksman(agent: Agent) { agent.strength += 2 }

fun applySizeAlteration(agent: Agent) { agent.strength += 1 }

fun applySuperIntelligence(agent: Agent) { agent.strength += 2}

fun applyInvulnerability(agent: Agent) { agent.strength += 3}

fun applyElementalManipulation(agent: Agent) { agent.strength += 4}

fun applySuperSpeed(agent: Agent) { agent.strength += 2 }

fun applyEnergyBlasts(agent: Agent, agentStrengthText: TextView, context: Context) {
    agent.strength += 1

    val dialogBuilder = AlertDialog.Builder(context)

    dialogBuilder.setTitle("Energy Blasts")
    dialogBuilder.setMessage("How many cards you discarding? (Extra +1 Bonus Each. Maximum of 3 Allowed)")

    var input: EditText = EditText(context)
    input.inputType = InputType.TYPE_CLASS_NUMBER
    dialogBuilder.setView(input)

    dialogBuilder.setPositiveButton("Confirm", DialogInterface.OnClickListener { dialog, which ->

        when (input.text.toString()) {
            "0" -> agent.strength += 0
            "1" -> agent.strength += 1
            "2" -> agent.strength += 2
            "3" -> agent.strength += 3
            else -> Toast.makeText(context, "That's not a valid number of discards.", Toast.LENGTH_SHORT).show()
        }

        agentStrengthText.text = agent.strength.toString()
    })

    val dialog: AlertDialog = dialogBuilder.create()
    dialog.show()
}

fun applySupersonicFlight(agent: Agent) { agent.strength += 1 }