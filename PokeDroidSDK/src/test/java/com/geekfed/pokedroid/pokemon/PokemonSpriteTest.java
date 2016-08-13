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
public class PokemonSpriteTest {

    // Test Variables
    private String testUrl = "http://boogie2988.com";

    private PokemonSprite pokemonSprite;

    @Before
    public void setUp() throws Exception {
        pokemonSprite = new PokemonSprite(testUrl);
    }

    @Test
    public void testGetUrl() throws Exception {
        assertEquals(testUrl, pokemonSprite.getUrl());
    }

    @Test
    public void testEquals() throws Exception {
        PokemonSprite samePokemonSprite = new PokemonSprite(testUrl);
        assertTrue(pokemonSprite.equals(samePokemonSprite));
    }

    @Test
    public void testNotEqual() throws Exception {
        PokemonSprite differentPokemonSprite = new PokemonSprite("not a url");
        assertFalse(pokemonSprite.equals(differentPokemonSprite));
    }

    @Test
    public void testHashCodeEquals() throws Exception {
        PokemonSprite samePokemonSprite = new PokemonSprite(testUrl);
        assertEquals(samePokemonSprite.hashCode(), pokemonSprite.hashCode());
    }

    @Test
    public void testHashCodeNotEquals() throws Exception {
        PokemonSprite differentPokemonSprite = new PokemonSprite("not a url");
        assertNotEquals(differentPokemonSprite.hashCode(), pokemonSprite.hashCode());
    }
}