package com.geekfed.pokedroid.pokemon;

import com.geekfed.pokedroid.item.Item;
import com.geekfed.pokedroid.move.Move;

import java.util.ArrayList;

/**
 * Created by cody on 5/13/16.
 */
public class Pokemon {

    private final ArrayList<PokemonAbility> mAbilities;
    private final ArrayList<PokemonForm> mForms;
    private final ArrayList<PokemonGameIndex> mGameIndicies;
    private final ArrayList<Item> mHeldItems;
    private final ArrayList<LocationAreaEncounter> mLocationAreaEncounters;
    private final ArrayList<Move> mMoves;
    private final ArrayList<Stat> mStats;
    private final ArrayList<PokemonType> mTypes;
    private final boolean mIsDefault;
    private final int mId;
    private final int mBaseExperience;
    private final int mHeight;
    private final int mOrder;
    private final int mWeight;
    private final PokemonSpecies mSpecies;
    private final PokemonSprites mSprites;
    private final String mName;

    private Pokemon(Builder builder) {
        mAbilities = builder.mAbilities;
        mForms = builder.mForms;
        mGameIndicies = builder.mGameIndicies;
        mHeldItems = builder.mHeldItems;
        mLocationAreaEncounters = builder.mLocationAreaEncounters;
        mMoves = builder.mMoves;
        mStats = builder.mStats;
        mTypes = builder.mTypes;
        mIsDefault = builder.mIsDefault;
        mId = builder.mId;
        mBaseExperience = builder.mBaseExperience;
        mHeight = builder.mHeight;
        mOrder = builder.mOrder;
        mWeight = builder.mWeight;
        mSpecies = builder.mSpecies;
        mSprites = builder.mSprites;
        mName = builder.mName;
    }

    public ArrayList<PokemonAbility> getAbilities() {
        return mAbilities;
    }

    public ArrayList<PokemonForm> getForms() {
        return mForms;
    }

    public ArrayList<PokemonGameIndex> getGameIndices() {
        return mGameIndicies;
    }

    public ArrayList<Item> getHeldItems() {
        return mHeldItems;
    }

    public ArrayList<LocationAreaEncounter> getLocationAreaEncounters() {
        return mLocationAreaEncounters;
    }

    public ArrayList<Move> getMoves() {
        return mMoves;
    }

    public ArrayList<Stat> getStats() {
        return mStats;
    }

    public ArrayList<PokemonType> getTypes() {
        return mTypes;
    }

    public boolean isDefault() {
        return mIsDefault;
    }

    public int getId() {
        return mId;
    }

    public int getBaseExperience() {
        return mBaseExperience;
    }

    public int getHeight() {
        return mHeight;
    }

    public int getOrder() {
        return mOrder;
    }

    public int getWeight() {
        return mWeight;
    }

    public PokemonSpecies getSpecies() {
        return mSpecies;
    }

    public PokemonSprites getSprites() {
        return mSprites;
    }

    public String getName() {
        return mName;
    }

    public static class Builder {
        private ArrayList<PokemonAbility> mAbilities;
        private ArrayList<PokemonForm> mForms;
        private ArrayList<PokemonGameIndex> mGameIndicies;
        private ArrayList<Item> mHeldItems;
        private ArrayList<LocationAreaEncounter> mLocationAreaEncounters;
        private ArrayList<Move> mMoves;
        private ArrayList<Stat> mStats;
        private ArrayList<PokemonType> mTypes;
        private boolean mIsDefault;
        private int mId;
        private int mBaseExperience;
        private int mHeight;
        private int mOrder;
        private int mWeight;
        private PokemonSpecies mSpecies;
        private PokemonSprites mSprites;
        private String mName;

        public Builder() {}

        public Builder abilities(ArrayList<PokemonAbility> abilities) {
            mAbilities = abilities;
            return this;
        }

        public Builder forms(ArrayList<PokemonForm> forms) {
            mForms = forms;
            return this;
        }

        public Builder gameIndicies(ArrayList<PokemonGameIndex> gameIndices) {
            mGameIndicies = gameIndices;
            return this;
        }

        public Builder heldItems(ArrayList<Item> heldItems) {
            mHeldItems = heldItems;
            return this;
        }

        public Builder locationAreaEncounters(ArrayList<LocationAreaEncounter> locationAreaEncounters) {
            mLocationAreaEncounters = locationAreaEncounters;
            return this;
        }

        public Builder moves(ArrayList<Move> moves) {
            mMoves = moves;
            return this;
        }

        public Builder stats(ArrayList<Stat> stats) {
            mStats = stats;
            return this;
        }

        public Builder types(ArrayList<PokemonType> types) {
            mTypes = types;
            return this;
        }

        public Builder isDefault(boolean isDefault) {
            mIsDefault = isDefault;
            return this;
        }

        public Builder id(int id) {
            mId = id;
            return this;
        }

        public Builder baseExperience(int baseExperience) {
            mBaseExperience = baseExperience;
            return this;
        }

        public Builder height(int height) {
            mHeight = height;
            return this;
        }

        public Builder order(int order) {
            mOrder = order;
            return this;
        }

        public Builder weight(int weight) {
            mWeight = weight;
            return this;
        }

        public Builder species(PokemonSpecies species) {
            mSpecies = species;
            return this;
        }

        public Builder sprites(PokemonSprites sprites) {
            mSprites = sprites;
            return this;
        }

        public Builder name(String name) {
            mName = name;
            return this;
        }

        public Pokemon build() {
            return new Pokemon(this);
        }
    }

}
