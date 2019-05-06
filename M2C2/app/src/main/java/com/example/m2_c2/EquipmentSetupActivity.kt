package com.example.m2_c2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.TextView

class EquipmentSetupActivity : AppCompatActivity() {
    private lateinit var equipmentRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipment_setup)

        // Store the information of the serialized agent from the previous activity into
        // an agent for this activity
        val agent: Agent = intent.extras.getSerializable("agent_id") as Agent

        // Display the Agent's base information
        val agentClassText: TextView = findViewById(R.id.agentClass_text)
        val agentSexText: TextView = findViewById(R.id.agentSex_text)
        val agentRankText: TextView = findViewById(R.id.agentRank_text)

        agentClassText.text = "Class: " + agent.name
        agentSexText.text = "Sex: " + agent.sex
        agentRankText.text = "Rank: " + agent.rank.toString()

        // Store a list of created Equipment cards to be displayed and potentially given to the Agent
        val equipmentList: MutableList<Equipment> = createEquipment()

        // Display a scrollable list of Equipment cards
        equipmentRecycler = findViewById(R.id.equipment_recycler)
        equipmentRecycler.layoutManager = LinearLayoutManager(this)
        equipmentRecycler.adapter = EquipmentAdapter(equipmentList)

        // Create a button that will move users to the next activity to add powers to the agent
        val addAlliesButton: Button = findViewById(R.id.addAllies_button)

        // WHen the button is pressed, create the Agent's equipment list to prevent duplicates and store all selected
        // Equipment cards from the list  Pass the serialized agent into the next activity for adding powers.
        addAlliesButton.setOnClickListener {
            agent.equipment.clear()

            for (item in equipmentList) {
                if (item.isSelected) agent.equipment.add(item)
            }

            val allySetupIntent = createAllySetupIntent(this, agent)

            startActivity(allySetupIntent)
        }
    }

    // Function that creates every base-game Equipment card and returns a list of it
    fun createEquipment(): MutableList<Equipment> {
        val headGear01 = Equipment(getString(R.string.thors_helmet), getString(R.string.headgear), 3, 400)
        val headGear02 = Equipment(getString(R.string.antmans_helmet),getString(R.string.headgear), 1, 200)
        val headGear03 = Equipment(getString(R.string.nick_furys_eyepatch),getString(R.string.headgear), 1, 100)
        val headGear04 = Equipment(getString(R.string.lokis_helmet),getString(R.string.headgear), 2, 500)
        val headGear05 = Equipment(getString(R.string.black_bolts_tuning_fork),getString(R.string.headgear), 2, 400)

        val armor01 = Equipment(getString(R.string.iron_man_model_one_armor),getString(R.string.armor), 1, 100)
        val armor02 = Equipment(getString(R.string.falcons_wingsuit),getString(R.string.armor), 2, 300)
        val armor03 = Equipment(getString(R.string.symbiote_suit), getString(R.string.armor), 2, 300)
        val armor04 = Equipment(getString(R.string.doctor_octopus_tentacle_suit), getString(R.string.armor), 4, 600)
        val armor05 = Equipment(getString(R.string.spidermans_spidey_suit), getString(R.string.armor), 2, 400)
        val armor06 = Equipment(getString(R.string.iron_mans_model_fifty_one_armor), getString(R.string.armor), 5, 700)

        val oneHanded01 = Equipment(getString(R.string.kravens_spear), getString(R.string.one_handed), 2, 400)
        val oneHanded02 = Equipment(getString(R.string.mjolnir), getString(R.string.one_handed), 2, 400)
        val oneHanded03 = Equipment(getString(R.string.klaws_sonic_blaster), getString(R.string.one_handed), 2, 400)
        val oneHanded04 = Equipment(getString(R.string.iron_mans_repulsor), getString(R.string.one_handed), 2, 300)
        val oneHanded05 = Equipment(getString(R.string.war_machines_wrist_rocket), getString(R.string.one_handed), 2, 200)
        val oneHanded06 = Equipment(getString(R.string.captain_americas_shield), getString(R.string.one_handed), 3, 500)
        val oneHanded07 = Equipment(getString(R.string.shield_pistol), getString(R.string.one_handed), 1, 100)
        val oneHanded08 = Equipment(getString(R.string.daredevils_billy_club), getString(R.string.one_handed), 1, 200)
        val oneHanded09 = Equipment(getString(R.string.widows_bite),getString(R.string.one_handed), 2, 200)

        val twoHanded01 = Equipment(getString(R.string.mandarins_rings), getString(R.string.two_handed), 2, 500)
        val twoHanded02 = Equipment(getString(R.string.spidermans_web_shooters), getString(R.string.two_handed), 2, 400)
        val twoHanded03 = Equipment(getString(R.string.absorbing_mans_ball_and_chain), getString(R.string.two_handed), 4, 500)
        val twoHanded04 = Equipment(getString(R.string.hawkeyes_bow), getString(R.string.two_handed), 3, 400)

        val footGear01 = Equipment(getString(R.string.sevenleagues_boots), getString(R.string.footgear), 2, 300)
        val footGear02 = Equipment(getString(R.string.namors_ankle_wings), getString(R.string.footgear), 1, 100)
        val footGear03 = Equipment(getString(R.string.green_goblins_globin_glider), getString(R.string.footgear), 2, 300)

        val equipmentList: MutableList<Equipment> = mutableListOf(headGear01, headGear02, headGear03, headGear04,
            headGear05, armor01, armor02, armor03, armor04, armor05, armor06, oneHanded01, oneHanded02,
            oneHanded03, oneHanded04, oneHanded05, oneHanded06, oneHanded07, oneHanded08, oneHanded09, twoHanded01,
            twoHanded02, twoHanded03, twoHanded04, footGear01, footGear02, footGear03)

        equipmentList.sortBy { it.name }

        return equipmentList
    }

    // Function that takes in an Agent object and creates an intent to
    // carry over its data into the Ally Setup activity
    private fun createAllySetupIntent(context: Context, agent: Agent): Intent {
        val intent = Intent(context, AllySetupActivity::class.java)

        // Serialize the Agent object to carry over data into next activity
        intent.putExtra("agent_id", agent)
        return intent
    }
}