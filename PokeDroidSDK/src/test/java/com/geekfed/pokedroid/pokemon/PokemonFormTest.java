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
 * Created by cody on 8/11/16.
 */
public class PokemonFormTest {

    // Test Variables
    private String testName = "TEST POKEMON FORM NAME";
    private String testUrl = "http://example.com";

    private PokemonForm pokemonForm;

    @Before
    public void setUp() throws Exception {
        pokemonForm = new PokemonForm(testName, testUrl);
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals(testName, pokemonForm.getName());
    }

    @Test
    public void testGetFormUrl() throws Exception {
        assertEquals(testUrl, pokemonForm.getFormUrl());
    }

    @Test
    public void testEqualsSameObject() throws Exception {
        assertTrue(pokemonForm.equals(pokemonForm));
    }

    @Test
    public void testEqualsDifferentObjectsSameValues() throws Exception {
        PokemonForm secondPokemonForm = new PokemonForm(testName, testUrl);
        assertTrue(pokemonForm.equals(secondPokemonForm));
    }

    @Test
    public void testDoesNotEqualWhenNull() throws Exception {
        assertFalse(pokemonForm.equals(null));
    }

    @Test
    public void testDoesNotEqualWhenObjectsNotSameValues() throws Exception {
        PokemonForm secondPokemonForm = new PokemonForm("not the same", testUrl);
        assertFalse(pokemonForm.equals(secondPokemonForm));
    }

    @Test
    public void testHashCodeEqual() throws Exception {
        PokemonForm secondPokemonForm = new PokemonForm(testName, testUrl);
        assertEquals(secondPokemonForm.hashCode(), pokemonForm.hashCode());
    }

    @Test
    public void testHashCodeNotEqual() throws Exception {
        PokemonForm secondPokemonForm = new PokemonForm(testName, "not a url");
        assertNotEquals(secondPokemonForm.hashCode(), pokemonForm.hashCode());
    }
}