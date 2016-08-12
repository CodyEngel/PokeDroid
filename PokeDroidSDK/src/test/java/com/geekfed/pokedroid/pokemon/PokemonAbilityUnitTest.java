/*
 * Copyright (c) 2016 Cody Engel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
    private int testSlot = 3;
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
