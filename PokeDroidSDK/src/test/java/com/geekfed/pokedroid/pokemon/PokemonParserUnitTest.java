package com.geekfed.pokedroid.pokemon;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        pokemonJSON = getPokemonJSON();
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

    private Pokemon parsePokemon() {
        PokemonParser pokemonParser = new PokemonParser(pokemonJSON);
        return pokemonParser.parse();
    }

    private JSONObject getPokemonJSON() throws JSONException {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", testId);
        jsonObject.put("name", testName);
        jsonObject.put("base_experience", testBaseExperience);
        jsonObject.put("height", testHeight);
        jsonObject.put("is_default", testIsDefault);
        jsonObject.put("order", testOrder);
        jsonObject.put("weight", testWeight);

        return jsonObject;
    }
}
