package com.example.m2_c2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class AgentSetupActivity : AppCompatActivity() {
    lateinit var agentClassSpinner: Spinner
    lateinit var agentSexSpinner: Spinner
    lateinit var agentRankSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agent_setup)

        // Find the ID of each spinner for creating the Agent and store them in their own variables
        agentClassSpinner = findViewById(R.id.agentClass_spinner)
        agentSexSpinner = findViewById(R.id.agentSex_spinner)
        agentRankSpinner = findViewById(R.id.agentRank_spinner)

        // Create adapters to grab available options and display them in their corresponding spinners
        ArrayAdapter.createFromResource(this, R.array.agentClass_array, android.R.layout.simple_spinner_dropdown_item).also {
            adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            agentClassSpinner.adapter = adapter
        }

        ArrayAdapter.createFromResource(this, R.array.agentSex_array, android.R.layout.simple_spinner_dropdown_item).also {
                adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            agentSexSpinner.adapter = adapter
        }

        ArrayAdapter.createFromResource(this, R.array.agentRank_array, android.R.layout.simple_spinner_dropdown_item).also {
                adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            agentRankSpinner.adapter = adapter
        }

        val agentEquipButton: Button = findViewById(R.id.equipAgent_button)

        agentEquipButton.setOnClickListener {
            // Store the choices that the users made for the agent's class, sex, and rank.
            val agentClass: String = agentClassSpinner.selectedItem.toString()
            val agentSex: String = agentSexSpinner.selectedItem.toString()
            val agentRank: Int = agentRankSpinner.selectedItem.toString().toInt()

            // Create the Agent object and pass it to the next activity for equipment customization.
            val agent = Agent(agentClass, agentSex, agentRank)

            val equipmentSetupIntent = createEquipmentSetupIntent(this, agent)
            startActivity(equipmentSetupIntent)
        }
    }

    // Function that takes in an Agent object and creates an intent to
    // carry over its data into the Equipment Setup activity
    private fun createEquipmentSetupIntent(context: Context, agent: Agent): Intent {
        val intent = Intent(context, EquipmentSetupActivity::class.java)

        // Serialize the Agent object to carry over data into next activity
        intent.putExtra("agent_id", agent)
        return intent
    }
}