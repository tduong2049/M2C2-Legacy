package com.example.m2_c2

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.TextView
import android.widget.Toast

fun applyFalcon(agent: Agent, agentStrengthText: TextView, context: Context) {
    agent.strength += 1

    val dialogBuilder = AlertDialog.Builder(context)

    dialogBuilder.setTitle("Falcon")
    dialogBuilder.setMessage("Is Redwing in play? (Extra +2 Bonus)")

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

fun applyIronMan(agent: Agent, context: Context) {
    agent.strength += 2

    if (agent.sex == "Female") { agent.strength += 2 }

    for (equipment in agent.equipment) {
        if (equipment.type == context.getString(R.string.armor)) { agent.strength += 2 }
    }
}

fun applyHawkeye(agent: Agent, context: Context) {
    agent.strength += 1

    var isAvenger: Boolean = false

    for (affiliation in agent.affiliations) {
        if (affiliation.name == context.getString(R.string.avengers)) { isAvenger = true }
    }

    if (isAvenger) { agent.strength += 2 }
}

fun applyThor(agent: Agent) { agent.strength += 4 }

fun applyCaptainMarvel(agent: Agent, context: Context) {
    agent.strength += 2

    var isInhuman: Boolean = false

    for (affiliation in agent.affiliations) {
        if (affiliation.name == context.getString(R.string.inhumans)) { isInhuman = true }
    }

    if (isInhuman) { agent.strength += 2 }
}

fun applySpiderman(agent: Agent, context: Context) {
    agent.strength += 2

    var isSpiderFriend: Boolean = false

    for (affiliation in agent.affiliations) {
        if (affiliation.name == context.getString(R.string.spider_friends)) { isSpiderFriend = true }
    }

    if (isSpiderFriend) { agent.strength += 2 }
}


fun applyBlackPanther(agent: Agent, agentStrengthText: TextView, context: Context) {
    agent.strength += 1

    val dialogBuilder = AlertDialog.Builder(context)

    dialogBuilder.setTitle("Black Panther")
    dialogBuilder.setMessage("Is Vibranium in play? (Extra +3 Bonus)")

    dialogBuilder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
        Toast.makeText(context, "Extra +3 Bonus", Toast.LENGTH_SHORT).show()
        agent.strength += 3
        agentStrengthText.text = agent.strength.toString()
    })


    dialogBuilder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
        Toast.makeText(context, "No Extra Bonus", Toast.LENGTH_SHORT).show()
    })

    val dialog: AlertDialog = dialogBuilder.create()
    dialog.show()
}

fun applyDaredevil (agent: Agent) { agent.strength += 1}

fun applyDaredevil(agent: Agent, agentStrengthText: TextView, context: Context) {
    agent.strength += 1

    val dialogBuilder = AlertDialog.Builder(context)

    dialogBuilder.setTitle("Daredevil")
    dialogBuilder.setMessage("Are you looking for trouble? (Extra +2 Bonus)")

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

fun applyBlackWidow(agent: Agent) { agent.strength += 1 }

fun applyHulk(agent: Agent) { agent.strength += 5}

fun applyNickFury(agent: Agent) { agent.strength += 1 }

fun applyCaptainAmerica(agent: Agent, context: Context) {
    agent.strength += 2

    var isAvenger: Boolean = false

    for (affiliation in agent.affiliations) {
        if (affiliation.name == context.getString(R.string.avengers)) { isAvenger = true }
    }

    if (isAvenger) { agent.strength += 2 }
}

fun applyAntman(agent: Agent) { agent.strength += 1 }

fun applySheHulk(agent: Agent) {
    agent.strength += 2

    if (agent.sex == "Male") { agent.strength += 2 }
}

fun applyTheVision(agent: Agent) { agent.strength += 2 }