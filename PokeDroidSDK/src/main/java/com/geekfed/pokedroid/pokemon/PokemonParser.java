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

import java.util.ArrayList;

/**
 * Created by cody on 5/14/16.
 */
public class PokemonParser {

    // Abilities
    public static final String JSON_KEY_ABILITIES_ARRAY     = "abilities";
    public static final String JSON_KEY_ABILITY_IS_HIDDEN   = "is_hidden";
    public static final String JSON_KEY_ABILITY_SLOT        = "slot";
    public static final String JSON_KEY_ABILITY_NAME        = "name";
    public static final String JSON_KEY_ABILITY_URL         = "url";
    public static final String JSON_KEY_ABILITY_OBJECT      = "ability";

    public static final String JSON_KEY_BASE_EXPERIENCE = "base_experience";

    // Forms
    public static final String JSON_KEY_FORMS_ARRAY = "forms";
    public static final String JSON_KEY_FORMS_NAME  = "name";
    public static final String JSON_KEY_FORMS_URL   = "url";

    // Game Indicies
    public static final String JSON_KEY_GAME_INDICES_ARRAY          = "game_indices";
    public static final String JSON_KEY_GAME_INDICES_VERSION        = "version";
    public static final String JSON_KEY_GAME_INDICES_VERSION_URL    = "url";
    public static final String JSON_KEY_GAME_INDICES_VERSION_NAME   = "name";
    public static final String JSON_KEY_GAME_INDICES_GAME_INDEX     = "game_index";

    // Held Items
    public static final String JSON_KEY_HELD_ITEMS_ARRAY    = "held_items";
    public static final String JSON_KEY_HELD_ITEMS_ITEM     = "item";
    public static final String JSON_KEY_HELD_ITEMS_NAME     = "name";
    public static final String JSON_KEY_HELD_ITEMS_URL      = "url";

    public static final String JSON_KEY_HEIGHT      = "height";
    public static final String JSON_KEY_ID          = "id";
    public static final String JSON_KEY_IS_DEFAULT  = "is_default";
    public static final String JSON_KEY_NAME        = "name";
    public static final String JSON_KEY_ORDER       = "order";
    public static final String JSON_KEY_WEIGHT      = "weight";

    JSONObject mPokemonJSON;

    public PokemonParser(String json) throws JSONException {
        mPokemonJSON = new JSONObject(json);
    }

    public PokemonParser(JSONObject pokemonJSON) {
        mPokemonJSON = pokemonJSON;
    }

    public Pokemon parse() {
        try {
            return new Pokemon.Builder()
                    .abilities(parsePokemonAbilities())
                    .baseExperience(parsePokemonBaseExperience())
                    .forms(parsePokemonForms())
                    .gameIndicies(parsePokemonGameIndices())
                    .heldItems(parsePokemonHeldItems())
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
            JSONArray abilityJSONArray = mPokemonJSON.getJSONArray(JSON_KEY_ABILITIES_ARRAY);
            for(int i = 0, size = abilityJSONArray.length(); i < size; i++) {
                JSONObject pokemonAbilityJSON = abilityJSONArray.getJSONObject(i);
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

    private ArrayList<PokemonForm> parsePokemonForms() throws JSONException {
        ArrayList<PokemonForm> pokemonForms = new ArrayList<>();

        if(mPokemonJSON.has(JSON_KEY_FORMS_ARRAY)) {
            JSONArray formsJSONArray = mPokemonJSON.getJSONArray(JSON_KEY_FORMS_ARRAY);
            for(int i = 0, size = formsJSONArray.length(); i < size; i++) {
                JSONObject formJSON = formsJSONArray.getJSONObject(i);
                pokemonForms.add(new PokemonForm(
                    formJSON.getString(JSON_KEY_FORMS_NAME),
                    formJSON.getString(JSON_KEY_FORMS_URL)
                ));
            }
        }

        return pokemonForms;
    }

    private ArrayList<PokemonGameIndex> parsePokemonGameIndices() throws JSONException {
        ArrayList<PokemonGameIndex> pokemonGameIndices = new ArrayList<>();

        JSONArray gameIndicesJSONArray = getJSONArray(JSON_KEY_GAME_INDICES_ARRAY);
        if(gameIndicesJSONArray != null) {
            for(int i = 0, size = gameIndicesJSONArray.length(); i < size; i++) {
                JSONObject gameIndexJSON = gameIndicesJSONArray.getJSONObject(i);
                pokemonGameIndices.add(new PokemonGameIndex(
                    gameIndexJSON.getInt(JSON_KEY_GAME_INDICES_GAME_INDEX),
                    gameIndexJSON.getJSONObject(JSON_KEY_GAME_INDICES_VERSION).getString(JSON_KEY_GAME_INDICES_VERSION_NAME),
                    gameIndexJSON.getJSONObject(JSON_KEY_GAME_INDICES_VERSION).getString(JSON_KEY_GAME_INDICES_VERSION_URL)
                ));
            }
        }

        return pokemonGameIndices;
    }

    private ArrayList<PokemonHeldItem> parsePokemonHeldItems() throws JSONException {
        ArrayList<PokemonHeldItem> heldItems = new ArrayList<>();

        JSONArray heldItemsJSONArray = getJSONArray(JSON_KEY_HELD_ITEMS_ARRAY);
        if(heldItemsJSONArray != null) {
            for(int i = 0, size = heldItemsJSONArray.length(); i < size; i++) {
                JSONObject heldItemJSON = heldItemsJSONArray.getJSONObject(i).getJSONObject(JSON_KEY_HELD_ITEMS_ITEM);
                heldItems.add(new PokemonHeldItem(
                    heldItemJSON.getString(JSON_KEY_HELD_ITEMS_NAME),
                    heldItemJSON.getString(JSON_KEY_HELD_ITEMS_URL)
                ));
            }
        }

        return heldItems;
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

    private JSONArray getJSONArray(String key) throws JSONException {
        if(mPokemonJSON.has(key)) {
            return mPokemonJSON.getJSONArray(key);
        }

        return null;
    }

    // Accessors
    public JSONObject getPokemonJSON() {
        return mPokemonJSON;
    }
}
