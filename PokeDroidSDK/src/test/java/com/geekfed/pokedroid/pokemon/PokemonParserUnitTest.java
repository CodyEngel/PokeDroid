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

    // Test Variables
    private boolean testIsDefault = true;

    private int testBaseExperience = 39,
            testHeight = 3,
            testId = 13,
            testOrder = 17,
            testWeight = 32;

    private String testName = "weedle";

    @Test
    public void pokemonParserWithBaseJSON() throws JSONException {
        JSONObject testJSON = getBaseJSON();
        PokemonParser pokemonParser = new PokemonParser(testJSON);
        assertEquals(testJSON, pokemonParser.getPokemonJSON());
    }

    @Test
    public void pokemonParserWithBaseJSONParseSetsPokemonId() throws JSONException {
        PokemonParser pokemonParser = new PokemonParser(getBaseJSON());
        Pokemon pokemon = pokemonParser.parse();

        assertEquals(testId, pokemon.getId());
    }

    private JSONObject getBaseJSON() throws JSONException {
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
