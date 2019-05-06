package com.example.m2_c2


import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.text.InputType
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

fun applyThorsHelmet(agent: Agent) { agent.strength += 3 }

fun applyAntMansHelmet(agent: Agent) {
    agent.strength += 1

    if (agent.rank <= 3) { agent.strength += 2}
}

fun applyNickFurysEyepatch(agent: Agent) { agent.strength += 1 }

fun applyLokisHelmet(agent: Agent) { agent.strength += 2 }

fun applyBlackBoltsTuningFork(agent: Agent, context: Context) {
    agent.strength += 2

    var foundInhumans: Boolean = false

    for (affiliation in agent.affiliations) {
        if (affiliation.name == context.getString(R.string.inhumans)) { foundInhumans = true }
    }

    if (foundInhumans) { agent.strength += 3 }
}

fun applyIronMansModelOneArmor(agent: Agent) { agent.strength += 1 }

fun applyFalconsWingsuit(agent: Agent) { agent.strength += 2 }

fun applySymbioteSuit(agent: Agent) { agent.strength += 2 }

fun applyDoctorOctopusTentacleSuit(agent: Agent, agentStrengthText: TextView, context: Context) {
    agent.strength += 4

    val dialogBuilder = AlertDialog.Builder(context)

    dialogBuilder.setTitle("Doctor Octopus' Tentacle Suit")
    dialogBuilder.setMessage("Discard an item worth at least 400 gold? (Extra +4 Bonus)")

    dialogBuilder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
        Toast.makeText(context, "Extra +4 Bonus", Toast.LENGTH_SHORT).show()
        agent.strength += 4
        agentStrengthText.text = agent.strength.toString()
    })


    dialogBuilder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
        Toast.makeText(context, "No Extra Bonus", Toast.LENGTH_SHORT).show()
    })

    val dialog: AlertDialog = dialogBuilder.create()
    dialog.show()
}

fun applySpiderManSpideySuit(agent: Agent) {
    agent.strength += 2

    for (affiliation in agent.affiliations) {
        if (affiliation.name == "Spider-Friends") { agent.strength += 2 }
    }
}

fun applyIronMansModelFiftyOneArmor(agent: Agent) { agent.strength += 5 }

fun applyKravensSpear(agent: Agent, agentStrengthText: TextView, context: Context) {
    agent.strength += 2

    val dialogBuilder = AlertDialog.Builder(context)

    dialogBuilder.setTitle("Kraven's Spear")
    dialogBuilder.setMessage("Equip Kraven's Spear as a Two-Handed Gear? (Extra +2 Bonus)")

    dialogBuilder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
        Toast.makeText(context, "Extra +2 Bonus", Toast.LENGTH_SHORT).show()
        agent.strength += 2
        agentStrengthText.text = agent.strength.toString()
    })


    dialogBuilder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
        Toast.makeText(context, "No Bonus Given.", Toast.LENGTH_SHORT).show()
    })

    val dialog: AlertDialog = dialogBuilder.create()
    dialog.show()
}

fun applyMjolnir(agent: Agent, agentStrengthText: TextView, context: Context) {
    agent.strength += 2

    var foundThor: Boolean = false

    for (ally in agent.allies) {
        if (ally.name == context.getString(R.string.thor)) {
            foundThor = true
        }
    }

    if (foundThor) { agent.strength += 4 }

    else {
        val dialogBuilder = AlertDialog.Builder(context)

        dialogBuilder.setTitle("Mjolnir")
        dialogBuilder.setMessage("Are you the highest level player? (Extra +4 Bonus)")

        dialogBuilder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
            Toast.makeText(context, "Extra +4 Bonus", Toast.LENGTH_SHORT).show()
            agent.strength += 4
            agentStrengthText.text = agent.strength.toString()
        })


        dialogBuilder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
            Toast.makeText(context, "No Bonus Given.", Toast.LENGTH_SHORT).show()
        })

        val dialog: AlertDialog = dialogBuilder.create()
        dialog.show()
    }
}

fun applyKlawsSonicBlaster(agent: Agent) { agent.strength += 2 }

fun applyIronMansRepulsor(agent: Agent, context: Context) {
    agent.strength += 2

    var hasIronManAdvantage: Boolean = false

    for (ally in agent.allies) {
        if (ally.name == context.getString(R.string.iron_man)) { hasIronManAdvantage = true }
    }

    for (equipment in agent.equipment) {
        if (equipment.name == context.getString(R.string.iron_man_model_one_armor) ||
            equipment.name == context.getString(R.string.iron_mans_model_fifty_one_armor)) { hasIronManAdvantage }
    }

    if (hasIronManAdvantage) { agent.strength += 2 }
}

fun applyWarMachinesWristRockets(agent: Agent) { agent.strength += 2}

fun applyCaptainAmericasShield(agent: Agent) { agent.strength += 3}

fun applyShieldPistol(agent: Agent) {
    agent.strength += 1

    if (agent.affiliations.isEmpty()) { agent.strength += 1}
}

fun applyDaredevilsBillyClub(agent: Agent, agentStrengthText: TextView, context: Context) {
    val dialogBuilder = AlertDialog.Builder(context)

    dialogBuilder.setTitle("Daredevil's Billy Club")
    dialogBuilder.setMessage("Discard this for a one-time bonus? (+4 Bonus)")

    dialogBuilder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
        Toast.makeText(context, "One-time +4 Bonus", Toast.LENGTH_SHORT).show()
        agent.strength += 4
        agentStrengthText.text = agent.strength.toString()
    })


    dialogBuilder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
        Toast.makeText(context, "No Bonus Given.", Toast.LENGTH_SHORT).show()
        agent.strength += 1
        agentStrengthText.text = agent.strength.toString()
    })

    val dialog: AlertDialog = dialogBuilder.create()
    dialog.show()
}

fun applyWidowsBite(agent: Agent, context: Context) {
    agent.strength += 2

    if (agent.sex == "Female") { agent.strength += 2}
}

fun applyMandarinsRings(agent: Agent, agentStrengthText: TextView, context: Context) {
    agent.strength += 2

    val dialogBuilder = AlertDialog.Builder(context)

    dialogBuilder.setTitle("Mandarin's Rings")
    dialogBuilder.setMessage("How many rings are you wearing? (Maximum of 10 Allowed)")

    var input: EditText = EditText(context)
    input.inputType = InputType.TYPE_CLASS_NUMBER
    dialogBuilder.setView(input)

    dialogBuilder.setPositiveButton("Confirm", DialogInterface.OnClickListener { dialog, which ->

        when (input.text.toString()) {
            "1" -> agent.strength += 1
            "2" -> agent.strength += 2
            "3" -> agent.strength += 3
            "4" -> agent.strength += 4
            "5" -> agent.strength += 5
            "6" -> agent.strength += 6
            "7" -> agent.strength += 7
            "8" -> agent.strength += 8
            "9" -> agent.strength += 9
            "10" -> agent.strength += 10
            else -> Toast.makeText(context, "That's not a valid number of rings.", Toast.LENGTH_SHORT).show()
        }

        agentStrengthText.text = agent.strength.toString()
    })

    val dialog: AlertDialog = dialogBuilder.create()
    dialog.show()
}

fun applySpidermanWebShooters(agent: Agent, context: Context) {
    agent.strength += 2

    var isSpiderFriends: Boolean = false

    for (affiliation in agent.affiliations) {
        if (affiliation.name == context.getString(R.string.spider_friends)) { isSpiderFriends = true }
    }

    if (isSpiderFriends) { agent.strength += 2 }
}

fun applyAbsorbingMansBallandChain(agent: Agent) { agent.strength += 4 }

fun applyHawkeyesbow(agent: Agent, context: Context) {
    agent.strength += 3

    var isAvengers: Boolean = false

    for (affiliation in agent.affiliations) {
        if (affiliation.name == context.getString(R.string.avengers)) { isAvengers = true }
    }

    if (isAvengers) { agent.strength += 2 }
}

fun applyGreenGoblinsGoblinGlider(agent: Agent) { agent.strength += 2 }

fun applyNamorsAnkleWings(agent: Agent) { agent.strength += 1 }

fun applySevenLeagueBoots(agent: Agent) { agent.strength += 2 }