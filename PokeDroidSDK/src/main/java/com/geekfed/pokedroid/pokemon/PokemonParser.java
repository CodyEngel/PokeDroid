package com.geekfed.pokedroid.pokemon;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by cody on 5/14/16.
 */
public class PokemonParser {

    private static String JSON_KEY_BASE_EXPERIENCE = "base_experience";
    private static String JSON_KEY_HEIGHT = "height";
    private static String JSON_KEY_ID = "id";
    private static String JSON_KEY_IS_DEFAULT = "is_default";
    private static String JSON_KEY_NAME = "name";
    private static String JSON_KEY_ORDER = "order";
    private static String JSON_KEY_WEIGHT = "weight";
    JSONObject mPokemonJSON;

    public PokemonParser(JSONObject pokemonJSON) {
        mPokemonJSON = pokemonJSON;
    }

    public Pokemon parse() {
        try {
            return new Pokemon.Builder()
                    .abilities(parsePokemonAbilities())
                    .baseExperience(parsePokemonBaseExperience())
                    .height(parsePokemonHeight())
                    .id(parsePokemonId())
                    .isDefault(parsePokemonIsDefault())
                    .name(parsePokemonName())
                    .order(parsePokemonOrder())
                    .weight(parsePokemonWeight())
                    .build();
        } catch(JSONException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    private ArrayList<PokemonAbility> parsePokemonAbilities() {
        return null;
    }

    private int parsePokemonBaseExperience() throws JSONException {
        return (int) mPokemonJSON.get(JSON_KEY_BASE_EXPERIENCE);
    }

    private int parsePokemonHeight() throws JSONException {
        return (int) mPokemonJSON.get(JSON_KEY_HEIGHT);
    }

    private int parsePokemonId() throws JSONException {
        return (int) mPokemonJSON.get(JSON_KEY_ID);
    }

    private boolean parsePokemonIsDefault() throws JSONException {
        return (boolean) mPokemonJSON.get(JSON_KEY_IS_DEFAULT);
    }

    private String parsePokemonName() throws JSONException {
        return (String) mPokemonJSON.get(JSON_KEY_NAME);
    }

    private int parsePokemonOrder() throws JSONException {
        return (int) mPokemonJSON.get(JSON_KEY_ORDER);
    }

    private int parsePokemonWeight() throws JSONException {
        return (int) mPokemonJSON.get(JSON_KEY_WEIGHT);
    }

    // Accessors
    public JSONObject getPokemonJSON() {
        return mPokemonJSON;
    }
}
