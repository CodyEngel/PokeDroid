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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by cody on 5/14/16.
 */
public class PokemonParserUnitTest {

    private JSONObject pokemonJSON;

    // Test Variables
    private boolean testIsDefault = true;

    private int testBaseExperience = 39,
            testHeight = 3,
            testId = 13,
            testOrder = 17,
            testWeight = 32;

    private String testName = "weedle";

    @Before
    public void setup() throws JSONException {
        pokemonJSON = getBasePokemonJSON();
    }

    @Test
    public void pokemonParserWithBaseJSON() {
        PokemonParser pokemonParser = new PokemonParser(pokemonJSON);
        assertEquals(pokemonJSON, pokemonParser.getPokemonJSON());
    }

    @Test
    public void pokemonParserWithBaseJSONParseSetsPokemonId() {
        Pokemon pokemon = parsePokemon();
        assertEquals(testId, pokemon.getId());
    }

    @Test
    public void pokemonParserWithBaseJSONParseSetsPokemonBaseExperience() {
        Pokemon pokemon = parsePokemon();
        assertEquals(testBaseExperience, pokemon.getBaseExperience());
    }

    @Test
    public void pokemonParserWithHeightJSONParseSetsPokemonHeight() {
        Pokemon pokemon = parsePokemon();
        assertEquals(testHeight, pokemon.getHeight());
    }

    @Test
    public void pokemonParserWithOrderJSONParseSetsPokemonOrder() {
        Pokemon pokemon = parsePokemon();
        assertEquals(testOrder, pokemon.getOrder());
    }

    @Test
    public void pokemonParserWithWeightJSONParseSetsPokemonWeight() {
        Pokemon pokemon = parsePokemon();
        assertEquals(testWeight, pokemon.getWeight());
    }

    @Test
    public void pokemonParserWithNameJSONParseSetsPokemonName() {
        Pokemon pokemon = parsePokemon();
        assertEquals(testName, pokemon.getName());
    }

    @Test
    public void pokemonParserWithIsDefaultJSONParseSetsPokemonIsDefault() {
        Pokemon pokemon = parsePokemon();
        assertEquals(testIsDefault, pokemon.isDefault());
    }

    @Test
    public void pokemonParserWithOneAbilityJSONParseSetsPokemonAbilities() throws JSONException {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(getFirstPokemonAbilityJSONObject());
        pokemonJSON.put(PokemonParser.JSON_KEY_ABILITIES_ARRAY, jsonArray);
        Pokemon pokemon = parsePokemon();

        assertEquals(1, pokemon.getAbilities().size());
        assertTrue(getFirstPokemonAbility().equals(pokemon.getAbilities().get(0)));
    }

    @Test
    public void pokemonParserWithTwoAbilitiesJSONParseSetsPokemonAbilities() throws JSONException {
        pokemonJSON.put(PokemonParser.JSON_KEY_ABILITIES_ARRAY, getTestPokemonAbilities());
        Pokemon pokemon = parsePokemon();

        assertEquals(2, pokemon.getAbilities().size());
        assertTrue(getFirstPokemonAbility().equals(pokemon.getAbilities().get(0)));
        assertTrue(getSecondPokemonAbility().equals(pokemon.getAbilities().get(1)));
    }

    @Test
    public void pokemonParserWithSingleFormButterfree() throws JSONException {
        Pokemon pokemon = new PokemonParser(getButterfreeJson()).parse();

        assertEquals(1, pokemon.getForms().size());
        assertEquals("butterfree", pokemon.getForms().get(0).getName());
        assertEquals("http://pokeapi.co/api/v2/pokemon-form/12/", pokemon.getForms().get(0).getFormUrl());
    }

    @Test
    public void pokemonParserWithMultipleFormsDeerling() throws JSONException {
        Pokemon pokemon = new PokemonParser(getDeerlingJSON()).parse();

        assertEquals(4, pokemon.getForms().size());

        // first form
        assertEquals("deerling-winter", pokemon.getForms().get(0).getName());
        assertEquals("http://pokeapi.co/api/v2/pokemon-form/10070/", pokemon.getForms().get(0).getFormUrl());

        // second form
        assertEquals("deerling-autumn", pokemon.getForms().get(1).getName());
        assertEquals("http://pokeapi.co/api/v2/pokemon-form/10069/", pokemon.getForms().get(1).getFormUrl());

        // third form
        assertEquals("deerling-summer", pokemon.getForms().get(2).getName());
        assertEquals("http://pokeapi.co/api/v2/pokemon-form/10068/", pokemon.getForms().get(2).getFormUrl());

        // fourth form
        assertEquals("deerling-spring", pokemon.getForms().get(3).getName());
        assertEquals("http://pokeapi.co/api/v2/pokemon-form/585/", pokemon.getForms().get(3).getFormUrl());
    }

    @Test
    public void pokemonParserWithSingleGameIndexButterfree() throws JSONException {
        Pokemon pokemon = new PokemonParser(getButterfreeJson()).parse();

        assertEquals(1, pokemon.getGameIndices().size());
        assertEquals(12, pokemon.getGameIndices().get(0).getGameIndex());
        assertEquals("white-2", pokemon.getGameIndices().get(0).getVersionName());
        assertEquals("http://pokeapi.co/api/v2/version/22/", pokemon.getGameIndices().get(0).getVersionUrl());
    }

    @Test
    public void pokemonParserWithMultipleGameIndicesDeerling() throws JSONException {
        Pokemon pokemon = new PokemonParser(getDeerlingJSON()).parse();

        assertEquals(4, pokemon.getGameIndices().size());

        // first game index
        int index = 0;

        assertEquals(585, pokemon.getGameIndices().get(index).getGameIndex());
        assertEquals("white-2", pokemon.getGameIndices().get(index).getVersionName());
        assertEquals("http://pokeapi.co/api/v2/version/22/", pokemon.getGameIndices().get(index).getVersionUrl());

        // second game index
        index = 1;

        assertEquals(585, pokemon.getGameIndices().get(index).getGameIndex());
        assertEquals("black-2", pokemon.getGameIndices().get(index).getVersionName());
        assertEquals("http://pokeapi.co/api/v2/version/21/", pokemon.getGameIndices().get(index).getVersionUrl());

        // third game index
        index = 2;

        assertEquals(585, pokemon.getGameIndices().get(index).getGameIndex());
        assertEquals("white", pokemon.getGameIndices().get(index).getVersionName());
        assertEquals("http://pokeapi.co/api/v2/version/18/", pokemon.getGameIndices().get(index).getVersionUrl());

        // fourth game index
        index = 3;

        assertEquals(585, pokemon.getGameIndices().get(index).getGameIndex());
        assertEquals("black", pokemon.getGameIndices().get(index).getVersionName());
        assertEquals("http://pokeapi.co/api/v2/version/17/", pokemon.getGameIndices().get(index).getVersionUrl());
    }

    private Pokemon parsePokemon() {
        PokemonParser pokemonParser = new PokemonParser(pokemonJSON);
        return pokemonParser.parse();
    }

    private JSONObject getBasePokemonJSON() throws JSONException {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put(PokemonParser.JSON_KEY_ID, testId);
        jsonObject.put(PokemonParser.JSON_KEY_NAME, testName);
        jsonObject.put(PokemonParser.JSON_KEY_BASE_EXPERIENCE, testBaseExperience);
        jsonObject.put(PokemonParser.JSON_KEY_HEIGHT, testHeight);
        jsonObject.put(PokemonParser.JSON_KEY_IS_DEFAULT, testIsDefault);
        jsonObject.put(PokemonParser.JSON_KEY_ORDER, testOrder);
        jsonObject.put(PokemonParser.JSON_KEY_WEIGHT, testWeight);

        return jsonObject;
    }

    private JSONArray getTestPokemonAbilities() throws JSONException {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(getFirstPokemonAbilityJSONObject());
        jsonArray.put(getSecondPokemonAbilityJSONObject());

        return jsonArray;
    }

    private JSONObject getFirstPokemonAbilityJSONObject() throws JSONException {
        JSONObject firstPokemonAbility = new JSONObject();
        firstPokemonAbility.put(PokemonParser.JSON_KEY_ABILITY_IS_HIDDEN, true);
        firstPokemonAbility.put(PokemonParser.JSON_KEY_ABILITY_SLOT, 3);

        JSONObject firstPokemonAbilityNestedAbility = new JSONObject();
        firstPokemonAbilityNestedAbility.put(PokemonParser.JSON_KEY_ABILITY_NAME, "run-away");
        firstPokemonAbilityNestedAbility.put(PokemonParser.JSON_KEY_ABILITY_URL, "http://pokeapi.co/api/v2/ability/50/");
        firstPokemonAbility.put(PokemonParser.JSON_KEY_ABILITY_OBJECT, firstPokemonAbilityNestedAbility);

        return firstPokemonAbility;
    }

    private PokemonAbility getFirstPokemonAbility() {
        return new PokemonAbility("run-away", "http://pokeapi.co/api/v2/ability/50/", true, 3);
    }

    private JSONObject getSecondPokemonAbilityJSONObject() throws JSONException {
        JSONObject secondPokemonAbility = new JSONObject();
        secondPokemonAbility.put(PokemonParser.JSON_KEY_ABILITY_IS_HIDDEN, false);
        secondPokemonAbility.put(PokemonParser.JSON_KEY_ABILITY_SLOT, 2);

        JSONObject secondPokemonAbilityNestedAbility = new JSONObject();
        secondPokemonAbilityNestedAbility.put(PokemonParser.JSON_KEY_ABILITY_NAME, "stay");
        secondPokemonAbilityNestedAbility.put(PokemonParser.JSON_KEY_ABILITY_URL, "http://pokeapi.co/api/v2/ability/51/");
        secondPokemonAbility.put(PokemonParser.JSON_KEY_ABILITY_OBJECT, secondPokemonAbilityNestedAbility);

        return secondPokemonAbility;
    }

    private PokemonAbility getSecondPokemonAbility() {
        return new PokemonAbility("stay", "http://pokeapi.co/api/v2/ability/51/", false, 2);
    }

    private String loadJson(String fileName) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(String.format("%s.json", fileName));
        Scanner scanner = new Scanner(is).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }

    private String getButterfreeJson() {
        return loadJson("pokemon_butterfree");
    }

    private String getDeerlingJSON() {
        return loadJson("pokemon_deerling");
    }
}
