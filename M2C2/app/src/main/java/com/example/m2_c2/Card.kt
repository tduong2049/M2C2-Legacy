package com.example.m2_c2

import java.io.Serializable

open class Card(val name: String = "Name", var isSelected: Boolean = false) : Serializable {
}

class Agent(name: String, val sex: String = "Male", var rank: Int = 1, var strength: Int = 0) : Card(name) {
        val equipment: MutableList<Equipment> = mutableListOf()
        val allies: MutableList<Ally> = mutableListOf()
        val powers: MutableList<Power> = mutableListOf()
        var affiliations: MutableList<Affiliation> = mutableListOf()
        val oneShots: MutableList<OneShot> = mutableListOf()
}

class Equipment(name: String, val type: String, var bonus: Int = 0, val goldValue: Int = 0) : Card(name)

class Ally(name: String, var bonus: Int = 0) : Card(name)

class OneShot(name: String, var playerBonus: Int = 0, var monsterBonus: Int = 0, val goldValue: Int = 0) : Card(name)

class Villian(name:String, val level: Int = 1, var strength: Int = 0): Card(name) {
    val modifiers: MutableList<MonsterModifier> = mutableListOf()
    val oneShots: MutableList<OneShot> = mutableListOf()
}

class Affiliation(name: String, var hasDisadvantages: Boolean = true) : Card(name)

class Power(name: String, val bonus: Int = 0, var rank: Int = 1) : Card(name)

class MonsterModifier(name: String, val strengthModifier: Int = 0) : Card(name)

class Trap(name: String) : Card(name)