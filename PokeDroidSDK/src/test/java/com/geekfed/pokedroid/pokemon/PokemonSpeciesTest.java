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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cody on 8/13/16.
 */
public class PokemonSpeciesTest {

    // Test Variables
    private String testName = "test pokemon species name";
    private String testUrl = "http://facespace.com";

    private PokemonSpecies pokemonSpecies;

    @Before
    public void setUp() throws Exception {
        pokemonSpecies = new PokemonSpecies(testName, testUrl);
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals(testName, pokemonSpecies.getName());
    }

    @Test
    public void testGetUrl() throws Exception {
        assertEquals(testUrl, pokemonSpecies.getUrl());
    }

    @Test
    public void testEqualsSameObject() throws Exception {
        assertTrue(pokemonSpecies.equals(pokemonSpecies));
    }

    @Test
    public void testEqualsDifferentObjectsSameValues() throws Exception {
        PokemonSpecies samePokemonSpecies = new PokemonSpecies(testName, testUrl);
        assertTrue(pokemonSpecies.equals(samePokemonSpecies));
    }

    @Test
    public void testDoesNotEqualWhenNull() throws Exception {
        assertFalse(pokemonSpecies.equals(null));
    }

    @Test
    public void testDoesNotEqualWhenObjectsNotSameValue() throws Exception {
        PokemonSpecies differentPokemonSpecies = new PokemonSpecies("not a name", "not a url");
        assertFalse(pokemonSpecies.equals(differentPokemonSpecies));
    }

    @Test
    public void testHashCodeEquals() throws Exception {
        PokemonSpecies samePokemonSpecies = new PokemonSpecies(testName, testUrl);
        assertEquals(samePokemonSpecies.hashCode(), pokemonSpecies.hashCode());
    }

    @Test
    public void testHashCodeNotEqual() throws Exception {
        PokemonSpecies differentPokemonSpecies = new PokemonSpecies("not a name", "not a url");
        assertNotEquals(differentPokemonSpecies.hashCode(), pokemonSpecies.hashCode());
    }
}