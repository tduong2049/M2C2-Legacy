package com.example.m2_c2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView

class EquipmentSetupActivity : AppCompatActivity() {
    private lateinit var equipmentRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipment_setup)

        val agent: Agent = intent.extras.getSerializable("agent_id") as Agent

        val agentClassText: TextView = findViewById(R.id.agentClass_text)
        val agentSexText: TextView = findViewById(R.id.agentSex_text)
        val agentRankText: TextView = findViewById(R.id.agentRank_text)

        agentClassText.text = "Class: " + agent.name
        agentSexText.text = "Sex: " + agent.sex
        agentRankText.text = "Rank: " + agent.rank.toString()

        val headGear01 = Equipment("Thor's Helmet", "Headgear", 3, 400)
        val headGear02 = Equipment("Ant-Man's Helmet", "Headgear", 1, 200)
        val headGear03 = Equipment("Nick Fury's Eyepatch", "Headgear", 1, 100)
        val headGear04 = Equipment("Loki's Helmet", "Headgear", 2, 500)
        val headGear05 = Equipment("Black Bolt's Tuning Folk", "Headgear", 2, 400)

        val armor01 = Equipment("Iron Man's Model 1 Armor", "Armor", 1, 100)
        val armor02 = Equipment("Falcon's Wingsuit", "Armor", 2, 300)
        val armor03 = Equipment("Symbiote Suit", "Armor", 2, 300)
        val armor04 = Equipment("Doctor Octopus' Tentacle Suit", "Armor", 4, 600)
        val armor05 = Equipment("Spider-Man's Spidey Suit", "Armor", 2, 400)
        val armor06 = Equipment("Iron Man's Model 51 Armor", "Armor", 5, 700)

        val oneHanded01 = Equipment("Kraven's Spear", "One Handed", 2, 400)
        val oneHanded02 = Equipment("Mjolnir", "One Handed", 2, 400)
        val oneHanded03 = Equipment("Klaw's Sonic Blaster", "One Handed", 2, 400)
        val oneHanded04 = Equipment("Iron Man's Repulsor", "One Handed", 2, 300)
        val oneHanded05 = Equipment("War Machine's Wrist Rocket", "One Handed", 2, 200)
        val oneHanded06 = Equipment("Captain America's Shield", "One Handed", 3, 500)
        val oneHanded07 = Equipment("S.H.I.E.L.D. Pistol", "One Handed", 1, 100)
        val oneHanded08 = Equipment("Daredevil's Billy Club", "One Handed", 1, 200)
        val oneHanded09 = Equipment("Widow's Bite", "One Handed", 2, 200)

        val twoHanded01 = Equipment("Mandarin's Rings", "Two Handed", 2, 500)
        val twoHanded02 = Equipment("Spider-Man's Web Shooters", "Two Handed", 2, 400)
        val twoHanded03 = Equipment("Absorbing Man's Ball and Chain", "Two Handed", 4, 500)
        val twoHanded04 = Equipment("Hawkeye's Bow", "Two Handed", 3, 400)

        val footGear01 = Equipment("Seven-League's Boots", "Footgear", 2, 300)
        val footGear02 = Equipment("Namor's Ankle Wings", "Footgear", 1, 100)
        val footGear03 = Equipment("Green Goblin's Goblin Glider", "Footgear", 2, 300)

        val equipmentList: MutableList<Equipment> = mutableListOf(headGear01, headGear02, headGear03, headGear04,
            headGear05, armor01, armor02, armor03, armor04, armor05, armor06, oneHanded01, oneHanded02,
            oneHanded03, oneHanded04, oneHanded05, oneHanded06, oneHanded07, oneHanded08, oneHanded09, twoHanded01,
            twoHanded02, twoHanded03, twoHanded04, footGear01, footGear02, footGear03)

        equipmentRecycler = findViewById(R.id.equipment_recycler)

        equipmentRecycler.layoutManager = LinearLayoutManager(this)
        equipmentRecycler.adapter = EquipmentAdapter(equipmentList)
    }
}