package com.geekfed.pokedroid.pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by cody on 5/14/16.
 */
public class PokemonParser {

    public static final String JSON_KEY_ABILITIES_ARRAY = "abilities";
    public static final String JSON_KEY_ABILITY_IS_HIDDEN = "is_hidden";
    public static final String JSON_KEY_ABILITY_SLOT = "slot";
    public static final String JSON_KEY_ABILITY_NAME = "name";
    public static final String JSON_KEY_ABILITY_URL = "url";
    public static final String JSON_KEY_ABILITY_OBJECT = "ability";
    public static final String JSON_KEY_BASE_EXPERIENCE = "base_experience";
    public static final String JSON_KEY_HEIGHT = "height";
    public static final String JSON_KEY_ID = "id";
    public static final String JSON_KEY_IS_DEFAULT = "is_default";
    public static final String JSON_KEY_NAME = "name";
    public static final String JSON_KEY_ORDER = "order";
    public static final String JSON_KEY_WEIGHT = "weight";

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

    private ArrayList<PokemonAbility> parsePokemonAbilities() throws JSONException {
        ArrayList<PokemonAbility> pokemonAbilities = new ArrayList<>();

        if(mPokemonJSON.has(JSON_KEY_ABILITIES_ARRAY)) {
            JSONArray pokemonAbilityJSONArray = mPokemonJSON.getJSONArray(JSON_KEY_ABILITIES_ARRAY);
            for(int i = 0; i < pokemonAbilityJSONArray.length(); i++) {
                JSONObject pokemonAbilityJSON = pokemonAbilityJSONArray.getJSONObject(i);
                JSONObject abilityJSON = pokemonAbilityJSON.getJSONObject(JSON_KEY_ABILITY_OBJECT);
                pokemonAbilities.add(new PokemonAbility(
                        abilityJSON.getString(JSON_KEY_ABILITY_NAME),
                        abilityJSON.getString(JSON_KEY_ABILITY_URL),
                        pokemonAbilityJSON.getBoolean(JSON_KEY_ABILITY_IS_HIDDEN),
                        pokemonAbilityJSON.getInt(JSON_KEY_ABILITY_SLOT)
                ));
            }
        }

        return pokemonAbilities;
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
