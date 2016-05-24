package com.geekfed.pokedroid.pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

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

    private Pokemon parsePokemon() {
        PokemonParser pokemonParser = new PokemonParser(pokemonJSON);
        return pokemonParser.parse();
    }

    private JSONObject getBasePokemonJSON() throws JSONException { // TODO: 5/23/16 need to test on different JSON configurations (some keys could be missing)
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
}
