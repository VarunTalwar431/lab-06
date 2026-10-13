package com.example.lab_6

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class WizardTest{
    private lateinit var evilWizard:Wizard
    // lateinit means we will assign the value later

    @Before
    fun setUp(){
        evilWizard = Wizard("Evil Wizard", 30, 10)
    }

    @Test
    fun castSpell_explosion_successful(){
        val damageDelt = evilWizard.castSpell("Explosion")
        assertEquals(30,damageDelt)// spellPower of 10 * 3 = 30
        assertEquals(20,evilWizard.mana) //mana of 30 - 10 = 20
    }

    @Test
    fun castSpell_explosion_unsuccessful(){
        evilWizard.mana = 5
        val damageDelt = evilWizard.castSpell(("Explosion"))
        assertEquals(0, damageDelt) // returns 0
        assertEquals(5, evilWizard.mana)// still remains 5

    }

    @Test
    fun castSpell_frostbite_successful(){
        val damageDelt = evilWizard.castSpell("Frostbite")
        assertEquals(20, damageDelt)
        assertEquals(25,evilWizard.mana)
    }

    @Test
    fun castSpell_frostbite_unsuccessful(){
        evilWizard.mana =4
        val damageDelt = evilWizard.castSpell("Frostbite")
        assertEquals(0,damageDelt )
        assertEquals(4, evilWizard.mana)
    }
}