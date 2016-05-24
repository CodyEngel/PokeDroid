package com.geekfed.pokedroid.pokemon;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by cody on 5/23/16.
 */
public class PokemonAbilityUnitTest {

    // Test Variables
    private int testSlot = 54;
    private String testAbilityName = "run-away",
        testAbilityUrl = "http://pokeapi.co/api/v2/ability/50/";

    @Test
    public void pokemonAbilityIsHiddenEqualsFalse() {
        PokemonAbility pokemonAbility = new PokemonAbility("", "", false, 0);
        assertFalse(pokemonAbility.isHidden());
    }

    @Test
    public void pokemonAbilityIsHiddenEqualsTrue() {
        PokemonAbility pokemonAbility = new PokemonAbility("", "", true, 0);
        assertTrue(pokemonAbility.isHidden());
    }

    @Test
    public void pokemonSlotEqualsTestSlot() {
        assertEquals(testSlot, getTestPokemonAbility().getSlot());
    }

    @Test
    public void pokemonAbilityNameEqualsTestAbilityName() {
        assertEquals(testAbilityName, getTestPokemonAbility().getAbilityName());
    }

    @Test
    public void pokemonAbilityUrlEqualsTestAbilityUrl() {
        assertEquals(testAbilityUrl, getTestPokemonAbility().getAbilityUrl());
    }

    @Test
    public void pokemonAbilityDifferentObjectsWithSameValuesEqualEachOther() {
        PokemonAbility firstPokemonAbility = getTestPokemonAbility();
        PokemonAbility secondPokemonAbility = getTestPokemonAbility();
        assertTrue(firstPokemonAbility.equals(secondPokemonAbility));
    }

    @Test
    public void pokemonAbilityDifferentObjectsWithDifferentValuesDontEqualEachOther() {
        PokemonAbility firstPokemonAbility = getTestPokemonAbility();
        PokemonAbility secondPokemonAbility = new PokemonAbility("", "", false, 0);
        assertFalse(firstPokemonAbility.equals(secondPokemonAbility));
    }

    private PokemonAbility getTestPokemonAbility() {
        return new PokemonAbility(testAbilityName, testAbilityUrl, false, testSlot);
    }
}
