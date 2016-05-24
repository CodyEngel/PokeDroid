package com.geekfed.pokedroid.pokemon;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by cody on 5/13/16.
 */
public class PokemonUnitTest {

    // Test Variables
    private boolean testIsDefault = false;

    private int testId = 43,
        testBaseExperience = 37,
        testHeight = 73,
        testOrder = 7,
        testWeight = 9000;

    private String testName = "Charmander";

    @Test
    public void pokemonBuilderWithId() {
        Pokemon pokemon = new Pokemon.Builder().id(testId).build();
        assertEquals(testId, pokemon.getId());
    }

    @Test
    public void pokemonBuilderWithBaseExperience() {
        Pokemon pokemon = new Pokemon.Builder().baseExperience(testBaseExperience).build();
        assertEquals(testBaseExperience, pokemon.getBaseExperience());
    }

    @Test
    public void pokemonBuilderWithHeight() {
        Pokemon pokemon = new Pokemon.Builder().height(testHeight).build();
        assertEquals(testHeight, pokemon.getHeight());
    }

    @Test
    public void pokemonBuilderWithOrder() {
        Pokemon pokemon = new Pokemon.Builder().order(testOrder).build();
        assertEquals(testOrder, pokemon.getOrder());
    }

    @Test
    public void pokemonBuilderWithWeight() {
        Pokemon pokemon = new Pokemon.Builder().weight(testWeight).build();
        assertEquals(testWeight, pokemon.getWeight());
    }

    @Test
    public void pokemonBuilderWithName() {
        Pokemon pokemon = new Pokemon.Builder().name(testName).build();
        assertEquals(testName, pokemon.getName());
    }

    @Test
    public void pokemonBuilderWithIsDefault() {
        Pokemon pokemon = new Pokemon.Builder().isDefault(testIsDefault).build();
        assertEquals(testIsDefault, pokemon.isDefault());
    }

    @Test
    public void pokemonBuilderWithAbilityList() {
        ArrayList<PokemonAbility> abilities = new ArrayList<>();
//        abilities.add(new PokemonAbility(""))
    }

}
