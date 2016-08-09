package com.geekfed.pokedroid.pokemon;

/**
 * Created by cody on 8/8/16.
 */
public class PokemonGameIndex {

    private int mGameIndex;

    private String mVersionName,
            mVersionUrl;

    public PokemonGameIndex(int gameIndex, String versionName, String versionUrl) {
        mGameIndex = gameIndex;
        mVersionName = versionName;
        mVersionUrl = versionUrl;
    }

    public int getGameIndex() {
        return mGameIndex;
    }

    public String getVersionName() {
        return mVersionName;
    }

    public String getVersionUrl() {
        return mVersionUrl;
    }
}
