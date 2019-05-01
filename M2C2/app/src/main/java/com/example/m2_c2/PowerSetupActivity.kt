package com.example.m2_c2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.TextView

class PowerSetupActivity : AppCompatActivity() {
    lateinit var chooseAffiliationsButton: Button
    lateinit var powerRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_power_setup)

        val agent: Agent = intent.extras.getSerializable("agent_id") as Agent

        val agentClassText: TextView = findViewById(R.id.agentClass_text)
        val agentSexText: TextView = findViewById(R.id.agentSex_text)
        val agentRankText: TextView = findViewById(R.id.agentRank_text)

        agentClassText.text = "Class: " + agent.name
        agentSexText.text = "Sex: " + agent.sex
        agentRankText.text = "Rank: " + agent.rank.toString()

        val powerList: MutableList<Power> = createPowers()

        powerRecycler = findViewById(R.id.power_recycler)
        powerRecycler.layoutManager = LinearLayoutManager(this)
        powerRecycler.adapter = PowerAdapter(powerList)

        chooseAffiliationsButton = findViewById(R.id.chooseAffiliations_button)

        chooseAffiliationsButton.setOnClickListener {
            agent.powers.clear()

            for (power in powerList) {
                if (power.isSelected) agent.powers.add(power)
            }

            val affiliationSetupIntent = createAffiliationSetupIntent(this, agent)

            startActivity(affiliationSetupIntent)
        }
    }

    // Function that creates every base-game Power card and returns a list of it
    fun createPowers(): MutableList<Power> {
        val power01 = Power("Master Tactician", 2, 2)
        val power02 = Power("Heightened Senses", 1, 1)
        val power03 = Power("Super-Strength", 3, 3)
        val power04 = Power("Martial Artist", 2, 1)
        val power05 = Power("Super Spy", 1, 1)
        val power06 = Power("Enhanced Agility", 2, 2)
        val power07 = Power("Super Soldier", 1, 2)
        val power08 = Power("Master Marksman", 2, 1)
        val power09 = Power("Size Alteration", 1,3)
        val power10 = Power("Super-Intelligence", 2, 3)
        val power11 = Power("Invulnerability", 3, 4)
        val power12 = Power("Elemental Manipulation", 4, 3)
        val power13 = Power("Super-Speed", 2,2)
        val power14 = Power("Energy Blasts",1,2)
        val power15 = Power("Supersonic Flight", 1,1)


        val powerList: MutableList<Power> = mutableListOf(power01, power02, power03, power04, power05, power06, power07,
            power08, power09, power10, power11, power12, power13, power14, power15)

        powerList.sortBy { it.name }

        return powerList
    }

    // Function that takes in an Agent object and creates an intent to
    // carry over its data into the Affiliation Setup activity
    private fun createAffiliationSetupIntent(context: Context, agent: Agent): Intent {
        val intent = Intent(context, AffiliationSetupActivity::class.java)

        // Serialize the Agent object to carry over data into next activity
        intent.putExtra("agent_id", agent)
        return intent
    }
}
