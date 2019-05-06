package com.example.m2_c2

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.text.InputType
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

fun applyAvengers(agent: Agent) {}

fun applyInhumans(agent: Agent) {
    agent.strength += agent.powers.size
}

fun applySpiderFriends(agent: Agent, agentStrengthText: TextView, context: Context) {
    val dialogBuilder = AlertDialog.Builder(context)

    dialogBuilder.setTitle("Spider-Friends")
    dialogBuilder.setMessage("Do you have two or fewer cards in your hand? (Extra +2 Bonus)")

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