package com.example.m2_c2

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_agent_summary.*
import org.w3c.dom.Text

class AgentSummaryActivity : AppCompatActivity() {
    lateinit var agentEquipmentRecycler: RecyclerView
    lateinit var agentAllyRecycler: RecyclerView
    lateinit var agentPowerRecycler: RecyclerView
    lateinit var calculateStrengthButton: Button
    lateinit var selectVillianButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agent_summary)

        val agent: Agent = intent.extras.getSerializable("agent_id") as Agent

        val agentClassText: TextView = findViewById(R.id.agentClass_text)
        val agentSexText: TextView = findViewById(R.id.agentSex_text)
        val agentRankText: TextView = findViewById(R.id.agentRank_text)
        val agentAffiliationText: TextView = findViewById(R.id.agentAffiliation_text)

        agentClassText.text = "Class: " + agent.name
        agentSexText.text = "Sex: " + agent.sex
        agentRankText.text = "Rank: " + agent.rank.toString()

        when {
            agent.affiliations.size == 1 && agent.affiliations[0].hasDisadvantages -> {
                agentAffiliationText.text = "Affiliation: " + "${agent.affiliations[0].name} " + "(Has Disadvantages)"
                agentAffiliationText.visibility = View.VISIBLE
            }

            agent.affiliations.size == 1 && !agent.affiliations[0].hasDisadvantages -> {
                agentAffiliationText.text = "Affiliation: " + "${agent.affiliations[0].name} " + "(No Disadvantages)"
                agentAffiliationText.visibility = View.VISIBLE
            }

            agent.affiliations.size == 2 -> {
                agentAffiliationText.text = "Affiliations: " + "${agent.affiliations[0].name} / ${agent.affiliations[1].name}"
                agentAffiliationText.visibility = View.VISIBLE
            }
        }

        val agentEquipmentText: TextView = findViewById(R.id.agentEquipment_text)
        agentEquipmentRecycler = findViewById(R.id.agentEquipment_recycler)

        val agentAllyText: TextView = findViewById(R.id.agentAlly_text)
        agentAllyRecycler = findViewById(R.id.agentAlly_recycler)

        val agentPowerText: TextView = findViewById(R.id.agentPower_text)
        agentPowerRecycler = findViewById(R.id.agentPower_recycler)

        if (agent.equipment.size > 0) {
            agentEquipmentText.visibility = View.VISIBLE
            agentEquipmentRecycler.visibility = View.VISIBLE
            agentEquipmentRecycler.layoutManager = LinearLayoutManager(this)
            agentEquipmentRecycler.adapter = AgentEquipmentAdapter(agent)
        }

        if (agent.allies.size > 0) {
            agentAllyText.visibility = View.VISIBLE
            agentAllyRecycler.visibility = View.VISIBLE
            agentAllyRecycler.layoutManager = LinearLayoutManager(this)
            agentAllyRecycler.adapter = AgentAllyAdapter(agent)
        }

        if (agent.powers.size > 0)  {
            agentPowerText.visibility = View.VISIBLE
            agentPowerRecycler.visibility = View.VISIBLE
            agentPowerRecycler.layoutManager = LinearLayoutManager(this)
            agentPowerRecycler.adapter = AgentPowerAdapter(agent)
        }

        val agentStrengthText: TextView = findViewById(R.id.agentStrength_text)

        calculateStrengthButton = findViewById(R.id.calculateStrength_button)
        calculateStrengthButton.setOnClickListener {
            agent.strength = agent.rank

            agentClassChecker(agent, this)
            agentAffiliationChecker(agent, agentStrengthText, this)
            agentEquipmentChecker(agent, agentStrengthText,this)
            agentAllyChecker(agent, agentStrengthText, this)
            agentPowerChecker(agent, agentStrengthText, this)
            agentStrengthText.text = agent.strength.toString()
        }

        selectVillianButton = findViewById(R.id.selectVillian_button)

        selectVillianButton.setOnClickListener {
            val villianSelectIntent = createVillianSelectIntent(this, agent)

            startActivity(villianSelectIntent)
        }
    }

    private fun agentEquipmentChecker(agent: Agent, agentStrengthText: TextView, context: Context) {
        for (equipment in agent.equipment) {
            when (equipment.name) {
                getString(R.string.thors_helmet) -> applyThorsHelmet(agent)
                getString(R.string.antmans_helmet) -> applyAntMansHelmet(agent)
                getString(R.string.nick_furys_eyepatch) -> applyNickFurysEyepatch(agent)
                getString(R.string.lokis_helmet) -> applyLokisHelmet(agent)
                getString(R.string.black_bolts_tuning_fork) -> applyBlackBoltsTuningFork(agent, context)

                getString(R.string.iron_man_model_one_armor) -> applyIronMansModelOneArmor(agent)
                getString(R.string.falcons_wingsuit) -> applyFalconsWingsuit(agent)
                getString(R.string.symbiote_suit) -> applySymbioteSuit(agent)
                getString(R.string.doctor_octopus_tentacle_suit) -> applyDoctorOctopusTentacleSuit(agent, agentStrengthText, context)
                getString(R.string.spidermans_spidey_suit) -> applySpiderManSpideySuit(agent)
                getString(R.string.iron_mans_model_fifty_one_armor) -> applyIronMansModelFiftyOneArmor(agent)

                getString(R.string.kravens_spear) -> applyKravensSpear(agent, agentStrengthText, context)
                getString(R.string.mjolnir) -> applyMjolnir(agent, agentStrengthText, context)
                getString(R.string.klaws_sonic_blaster) -> applyKlawsSonicBlaster(agent)
                getString(R.string.iron_mans_repulsor) -> applyIronMansRepulsor(agent, context)
                getString(R.string.war_machines_wrist_rocket) -> applyWarMachinesWristRockets(agent)
                getString(R.string.captain_americas_shield) -> applyCaptainAmericasShield(agent)
                getString(R.string.shield_pistol) -> applyShieldPistol(agent)
                getString(R.string.daredevils_billy_club) -> applyDaredevilsBillyClub(agent, agentStrengthText, context)
                getString(R.string.widows_bite) -> applyWidowsBite(agent, context)

                getString(R.string.mandarins_rings) -> applyMandarinsRings(agent, agentStrengthText, context)
                getString(R.string.spidermans_web_shooters) -> applySpidermanWebShooters(agent, context)
                getString(R.string.absorbing_mans_ball_and_chain) -> applyAbsorbingMansBallandChain(agent)
                getString(R.string.hawkeyes_bow) -> applyHawkeyesbow(agent, context)

                getString(R.string.sevenleagues_boots) -> applySevenLeagueBoots(agent)
                getString(R.string.namors_ankle_wings) -> applyNamorsAnkleWings(agent)
                getString(R.string.green_goblins_globin_glider) -> applyGreenGoblinsGoblinGlider(agent)
            }
        }
    }//end agent equipment checker

    private fun agentAllyChecker(agent: Agent, agentStrengthText: TextView, context: Context) {
        for (ally in agent.allies) {
            when (ally.name) {
                getString(R.string.falcon) -> applyFalcon(agent, agentStrengthText, context)
                getString(R.string.iron_man) -> applyIronMan(agent, context)
                getString(R.string.hawkeye) -> applyHawkeye(agent, context)
                getString(R.string.thor) -> applyThor(agent)
                getString(R.string.captain_marvel) -> applyCaptainMarvel(agent, context)
                getString(R.string.spiderman) -> applySpiderman(agent, context)
                getString(R.string.black_panther) -> applyBlackPanther(agent, agentStrengthText, context)
                getString(R.string.daredevil) -> applyDaredevil(agent)
                getString(R.string.black_widow) -> applyBlackWidow(agent)
                getString(R.string.hulk) -> applyHulk(agent)
                getString(R.string.nick_fury) -> applyNickFury(agent)
                getString(R.string.captain_america) -> applyCaptainAmerica(agent, context)
                getString(R.string.antman) -> applyAntman(agent)
                getString(R.string.shehulk) -> applySheHulk(agent)
                getString(R.string.the_vision) -> applyTheVision(agent)
            }
        }
    }// end agent's ally checker

    private fun agentPowerChecker(agent: Agent, agentStrengthText: TextView, context: Context) {
        for (power in agent.powers) {
            when (power.name) {
                getString(R.string.master_tactician) -> applyMasterTactician(agent, agentStrengthText, context)
                getString(R.string.heightened_senses) -> applyHeightenedSenses(agent)
                getString(R.string.super_strength) -> applySuperStrength(agent, context)
                getString(R.string.martial_artist) -> applyMartialArtist(agent)
                getString(R.string.super_spy) -> applySuperSpy(agent)
                getString(R.string.enhanced_agility) -> applyEnhancedAgility(agent)
                getString(R.string.super_soldier) -> applySuperSoldier(agent)
                getString(R.string.master_marksman) -> applyMasterMarksman(agent)
                getString(R.string.size_alteration) -> applySizeAlteration(agent)
                getString(R.string.super_intelligence) -> applySuperIntelligence(agent)
                getString(R.string.invulnerability) -> applyInvulnerability(agent)
                getString(R.string.elemental_manipulation) -> applyElementalManipulation(agent)
                getString(R.string.super_speed) -> applySuperSpeed(agent)
                getString(R.string.energy_blasts) -> applyEnergyBlasts(agent, agentStrengthText, context)
                getString(R.string.supersonic_flight) -> applySupersonicFlight(agent)
            }
        }
    }// end agent's power checker

    private fun agentAffiliationChecker(agent: Agent, agentStrengthText: TextView, context: Context) {
        for (affiliation in agent.affiliations) {
            when (affiliation.name) {
                getString(R.string.inhumans) -> applyInhumans(agent)
                getString(R.string.spider_friends) -> applySpiderFriends(agent, agentStrengthText, context)
            }
        }
    }

    private fun agentClassChecker(agent: Agent, context: Context) {
        when (agent.name) {
            getString(R.string.recruiting_agent) -> applyRecruitingAgent(agent)
            getString(R.string.tech_agent) -> applyTechAgent(agent, context)
        }
    }

    private fun createVillianSelectIntent(context: Context, agent: Agent): Intent {
        val intent = Intent(context, VillianSelectActivity::class.java)

        // Serialize the Agent object to carry over data into next activity
        intent.putExtra("agent_id", agent)
        return intent
    }
}// end onCreate activity
