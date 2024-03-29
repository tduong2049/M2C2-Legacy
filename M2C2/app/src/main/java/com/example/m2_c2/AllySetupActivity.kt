package com.example.m2_c2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.TextView

class AllySetupActivity : AppCompatActivity() {
    lateinit var allyRecycler: RecyclerView
    lateinit var addPowersButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ally_setup)

        val agent: Agent = intent.extras.getSerializable("agent_id") as Agent

        val agentClassText: TextView = findViewById(R.id.agentClass_text)
        val agentSexText: TextView = findViewById(R.id.agentSex_text)
        val agentRankText: TextView = findViewById(R.id.agentRank_text)

        agentClassText.text = "Class: " + agent.name
        agentSexText.text = "Sex: " + agent.sex
        agentRankText.text = "Rank: " + agent.rank.toString()

        val allyList: MutableList<Ally> = createAllies()

        allyRecycler = findViewById(R.id.ally_recycler)
        allyRecycler.layoutManager = LinearLayoutManager(this)
        allyRecycler.adapter = AllyAdapter(allyList)

        addPowersButton = findViewById(R.id.addPowers_button)

        addPowersButton.setOnClickListener {
            agent.allies.clear()

            for (ally in allyList) {
                if (ally.isSelected) agent.allies.add(ally)
            }

            val allySetupIntent = createPowerSetupIntent(this, agent)

            startActivity(allySetupIntent)
        }
    }

    // Function that creates every base-game Ally card and returns a list of it
    fun createAllies(): MutableList<Ally> {
        val ally01 = Ally(getString(R.string.falcon), 1)
        val ally02 = Ally(getString(R.string.iron_man), 2)
        val ally03 = Ally(getString(R.string.hawkeye), 1)
        val ally04 = Ally(getString(R.string.thor), 4)
        val ally05 = Ally(getString(R.string.captain_marvel), 2)
        val ally06 = Ally(getString(R.string.spiderman), 2)
        val ally07 = Ally(getString(R.string.black_panther), 1)
        val ally08 = Ally(getString(R.string.daredevil), 1)
        val ally09 = Ally(getString(R.string.black_widow), 1)
        val ally10 = Ally(getString(R.string.hulk), 5)
        val ally11 = Ally(getString(R.string.nick_fury), 1)
        val ally12 = Ally(getString(R.string.captain_america), 2)
        val ally13 = Ally(getString(R.string.antman), 1)
        val ally14 = Ally(getString(R.string.shehulk), 2)
        val ally15 = Ally(getString(R.string.the_vision), 2)


        val allyList: MutableList<Ally> = mutableListOf(ally01, ally02, ally03, ally04, ally05, ally06, ally07,
            ally08, ally09, ally10, ally11, ally12, ally13, ally14, ally15)

        allyList.sortBy { it.name }

        return allyList
    }

    // Function that takes in an Agent object and creates an intent to
    // carry over its data into the Power Setup activity
    private fun createPowerSetupIntent(context: Context, agent: Agent): Intent {
        val intent = Intent(context, PowerSetupActivity::class.java)

        // Serialize the Agent object to carry over data into next activity
        intent.putExtra("agent_id", agent)
        return intent
    }
}