package com.example.m2_c2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import org.jetbrains.anko.find

class AffiliationSetupActivity : AppCompatActivity() {
    lateinit var affiliationOneSpinner: Spinner
    lateinit var affiliationTwoSpinner: Spinner
    lateinit var teamUpSwitch: Switch
    lateinit var affiliationTwoText: TextView
    lateinit var selectVillainButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_affiliation_setup)

        val agent: Agent = intent.extras.getSerializable("agent_id") as Agent

        val agentClassText: TextView = findViewById(R.id.agentClass_text)
        val agentSexText: TextView = findViewById(R.id.agentSex_text)
        val agentRankText: TextView = findViewById(R.id.agentRank_text)

        agentClassText.text = "Class: " + agent.name
        agentSexText.text = "Sex: " + agent.sex
        agentRankText.text = "Rank: " + agent.rank.toString()

        // Find the ID of each spinner for choosing the Agent's affiliations and store them in their own variables
        affiliationOneSpinner = findViewById(R.id.affiliatonOne_spinner)
        affiliationTwoSpinner = findViewById(R.id.affiliatonTwo_spinner)

        // Create adapters to grab available options and display them in their corresponding spinners
        ArrayAdapter.createFromResource(this, R.array.affiliation_array, android.R.layout.simple_spinner_dropdown_item).also {
                adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            affiliationOneSpinner.adapter = adapter
        }

        ArrayAdapter.createFromResource(this, R.array.affiliation_array, android.R.layout.simple_spinner_dropdown_item).also {
                adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            affiliationTwoSpinner.adapter = adapter
        }

        affiliationTwoText = findViewById(R.id.affiliationTwo_text)

        teamUpSwitch = findViewById(R.id.teamUp_switch)

        teamUpSwitch.setOnClickListener {
            if (teamUpSwitch.isChecked) {
                affiliationTwoText.visibility = View.VISIBLE
                affiliationTwoSpinner.visibility = View.VISIBLE
            }

            else {
                affiliationTwoText.visibility = View.GONE
                affiliationTwoSpinner.visibility = View.GONE
            }
        }

        selectVillainButton = findViewById(R.id.selectVillian_button)

        selectVillainButton.setOnClickListener {
            affiliationChoiceChecker(agent, affiliationOneSpinner, affiliationTwoSpinner, teamUpSwitch)
        }
    }

    private fun affiliationChoiceChecker(agent: Agent, affiliationOneSpinner: Spinner, affiliationTwoSpinner: Spinner,
                                         teamUpSwitch: Switch) {
        agent.affiliations.clear()

        val affiliationOneName: String = affiliationOneSpinner.selectedItem.toString()
        val affiliationTwoName: String = affiliationTwoSpinner.selectedItem.toString()

        if (affiliationOneName.length > 1) {
            val affiliation01 = Affiliation(affiliationOneName)
            agent.affiliations.add(affiliation01)
        }

        if (affiliationTwoName.length > 1) {
            val affiliation02 = Affiliation(affiliationTwoName)
            agent.affiliations.add(affiliation02)
        }

        if (teamUpSwitch.isChecked && (agent.affiliations.size == 1)) { agent.affiliations[0].hasDisadvantages = false }
    }
}