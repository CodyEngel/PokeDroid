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

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by cody on 5/13/16.
 */
public class PokemonUnitTest {

    // Test Variables
    private boolean testIsDefault = false;

    private int testId = 43,
        testBaseExperience = 37,
        testHeight = 73,
        testOrder = 7,
        testWeight = 9000;

    private String testName = "Charmander";

    @Test
    public void pokemonBuilderWithId() {
        Pokemon pokemon = new Pokemon.Builder().id(testId).build();
        assertEquals(testId, pokemon.getId());
    }

    @Test
    public void pokemonBuilderWithBaseExperience() {
        Pokemon pokemon = new Pokemon.Builder().baseExperience(testBaseExperience).build();
        assertEquals(testBaseExperience, pokemon.getBaseExperience());
    }

    @Test
    public void pokemonBuilderWithHeight() {
        Pokemon pokemon = new Pokemon.Builder().height(testHeight).build();
        assertEquals(testHeight, pokemon.getHeight());
    }

    @Test
    public void pokemonBuilderWithOrder() {
        Pokemon pokemon = new Pokemon.Builder().order(testOrder).build();
        assertEquals(testOrder, pokemon.getOrder());
    }

    @Test
    public void pokemonBuilderWithWeight() {
        Pokemon pokemon = new Pokemon.Builder().weight(testWeight).build();
        assertEquals(testWeight, pokemon.getWeight());
    }

    @Test
    public void pokemonBuilderWithName() {
        Pokemon pokemon = new Pokemon.Builder().name(testName).build();
        assertEquals(testName, pokemon.getName());
    }

    @Test
    public void pokemonBuilderWithIsDefault() {
        Pokemon pokemon = new Pokemon.Builder().isDefault(testIsDefault).build();
        assertEquals(testIsDefault, pokemon.isDefault());
    }

    @Test
    public void pokemonBuilderWithAbilityList() {
        ArrayList<PokemonAbility> abilities = new ArrayList<>();
        abilities.add(getTestPokemonAbility());

        Pokemon pokemon = new Pokemon.Builder().abilities(abilities).build();
        assertEquals(abilities, pokemon.getAbilities());
    }

    private PokemonAbility getTestPokemonAbility() {
        return new PokemonAbility("run-away", "http://pokeapi.co/api/v2/ability/50/", true, 3);
    }

}
