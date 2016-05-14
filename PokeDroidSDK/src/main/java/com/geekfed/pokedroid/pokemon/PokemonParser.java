package com.geekfed.pokedroid.pokemon;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by cody on 5/14/16.
 */
public class PokemonParser {

    JSONObject mPokemonJSON;

    public PokemonParser(JSONObject pokemonJSON) {
        mPokemonJSON = pokemonJSON;
    }

    public Pokemon parse() throws JSONException {
        return new Pokemon.Builder()
                .id(parsePokemonId())
                .build();
    }

    private int parsePokemonId() throws JSONException {
        return (int) mPokemonJSON.get("id");
    }

    // Accessors
    public JSONObject getPokemonJSON() {
        return mPokemonJSON;
    }
}
