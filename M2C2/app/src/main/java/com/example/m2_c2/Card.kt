package com.example.m2_c2

import java.io.Serializable

open class Card(val name: String = "Name") : Serializable {
}

class Agent(name: String, val sex: String = "Male", var rank: Int = 1,
                var strength: Int = 0) : Card(name) {
        val equipment: MutableList<Equipment> = mutableListOf()
        val allies: MutableList<Ally> = mutableListOf()
}

class Equipment(name: String, type: String, var bonus: Int = 0, val goldValue: Int = 0)
        : Card(name) {
}

class Ally(name: String, var bonus: Int = 0) : Card(name) {
}

class OneShot(name: String, var playerBonus: Int = 0, var monsterBonus: Int = 0,
              val goldValue: Int = 0) : Card(name) {
}

class Monster(name:String, val level: Int = 1, val badStuffText: String, var strength: Int,
              var levelGain: Int = 1) : Card(name) {
}

class Affiliation(name: String) : Card(name) {

}

class Power(name: String, val bonus: Int = 0, var rank: Int = 1) : Card(name) {

}

class MonsterModifier(name: String, val strengthModifier: Int = 0) : Card(name) {

}

class Trap(name: String) : Card(name) {

}
