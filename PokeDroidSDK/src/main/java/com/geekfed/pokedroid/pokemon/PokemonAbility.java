package com.geekfed.pokedroid.pokemon;

/**
 * Created by cody on 5/13/16.
 */
public class PokemonAbility extends Object {

    private boolean mIsHidden;
    private int mSlot;
    private String mAbilityName,
            mAbilityUrl;

    public PokemonAbility(String abilityName, String abilityUrl, boolean isHidden, int slot) {
        mAbilityName = abilityName;
        mAbilityUrl = abilityUrl;
        mIsHidden = isHidden;
        mSlot = slot;
    }

    public boolean isHidden() {
        return mIsHidden;
    }

    public int getSlot() {
        return mSlot;
    }

    public String getAbilityName() {
        return mAbilityName;
    }

    public String getAbilityUrl() {
        return mAbilityUrl;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        if(!((PokemonAbility) obj).getAbilityName().equals(getAbilityName())) return false;
        if(!((PokemonAbility) obj).getAbilityUrl().equals(getAbilityUrl())) return false;
        if(((PokemonAbility) obj).getSlot() != getSlot()) return false;
        if(((PokemonAbility) obj).isHidden() != isHidden()) return false;

        return true;
    }

    // TODO: 5/23/16 need to add the ability to get additional ability info from url, see Ability class
}
